package com.cat.oqj4j.antlr.listener;

import com.cat.oqj4j.antlr.gen.SelectStatementBaseListener;
import com.cat.oqj4j.antlr.gen.SelectStatementParser;
import com.cat.oqj4j.antlr.type.*;
import com.cat.oqj4j.core.OqlCoreProfile;
import com.cat.oqj4j.exception.BeanHandlingException;
import com.cat.oqj4j.exception.OqlExpResolvedException;
import com.cat.oqj4j.support.AntlrHelper;
import com.cat.oqj4j.support.BeanHandler;
import com.cat.oqj4j.support.ClassHelper;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

/**
 * select表达式监听器
 * @author gwj
 */
public class SelectStatementListener extends SelectStatementBaseListener {
    /**
     * oql核心剖面
     */
    private final OqlCoreProfile coreProfile;
    /**
     * 节点栈
     */
    private final Deque<ExpType> nodeStack = new LinkedList<>();
    /**
     * 操作原对象集合
     */
    private final Collection<?> srcCol;

    /**
     * 是否已取出结果
     */
    private boolean isAlreadFetchResult;

    /**
     * 构造对象
     * @param coreProfile 核心剖面
     * @param srcCol 原对象
     */
    public SelectStatementListener(OqlCoreProfile coreProfile, Collection<?> srcCol) {
        if (srcCol == null) {
            throw new IllegalArgumentException("操作集合不能为空");
        }
        this.coreProfile = coreProfile;
        this.srcCol = srcCol;
    }

    @Override
    public void exitDirectSelect(SelectStatementParser.DirectSelectContext ctx) {
        ParseTree child = ctx.getChild(0);
        String alias = null;
        /**
         * 1、如果是字段取值表达式，映射的别名默认取字段名
         * 2、如果是函数表达式，映射的别名默认取表函数名
         * 3、兜底使用原始名称作为映射名
         */
        if (child instanceof SelectStatementParser.FieldPlaceValContext) {
            alias = FieldPlaceValExpType.getFieldName(child.getText());
        } else if (child instanceof SelectStatementParser.FunPlaceValContext) {
            alias = FunPlaceValExpType.getFunName(child.getText());
        } else {
            alias = child.getText();
        }
        nodeStack.push(new DirectSelectExpType(ctx.getText(), alias));
    }

    @Override
    public void exitAliasSelect(SelectStatementParser.AliasSelectContext ctx) {
        // 格式：name alias
        nodeStack.push(new AliasSelectExpType(ctx.getText(), ctx.getChild(1).getText()));
    }

    @Override
    public void exitAsAliasSelect(SelectStatementParser.AsAliasSelectContext ctx) {
        // 格式：name as alias
        nodeStack.push(new AsAliasSelectExpType(ctx.getText(), ctx.getChild(2).getText()));
    }

    @Override
    public void exitStringVal(SelectStatementParser.StringValContext ctx) {
        nodeStack.push(new StringValExpType(ctx.getText()));
    }

    @Override
    public void exitNumberVal(SelectStatementParser.NumberValContext ctx) {
        nodeStack.push(new NumberValExpType(ctx.getText()));
    }

    @Override
    public void exitBooleanVal(SelectStatementParser.BooleanValContext ctx) {
        nodeStack.push(new BooleanValExpType(ctx.getText()));
    }

    @Override
    public void exitNullVal(SelectStatementParser.NullValContext ctx) {
        nodeStack.push(new NullValExpType(ctx.getText()));
    }

    @Override
    public void exitFieldPlaceVal(SelectStatementParser.FieldPlaceValContext ctx) {
        nodeStack.push(new FieldPlaceValExpType(ctx.getText(), this.coreProfile));
    }

    @Override
    public void exitFunPlaceVal(SelectStatementParser.FunPlaceValContext ctx) {
        FunPlaceValExpType funPlaceValType = new FunPlaceValExpType(ctx.getText(), this.coreProfile, this.srcCol);
        // 取出函数占位符
        FunPlaceExpType funPlaceExpType = (FunPlaceExpType) nodeStack.pop();
        // 添加对应参数的表达式
        for (int i = 0; i < funPlaceExpType.getArgQuantity(); i++) {
            funPlaceValType.addArgExpTypes((ValExpType) nodeStack.pop());
        }
        // 使用栈堆方式入参，故需要进行反转，参数顺序才和表达式一致
        funPlaceValType.reverseArg();
        nodeStack.push(funPlaceValType);
    }

    @Override
    public void exitFunPlace(SelectStatementParser.FunPlaceContext ctx) {
        FunPlaceExpType funPlaceExpType = AntlrHelper.generateFunPlaceExpType(ctx);
        nodeStack.push(funPlaceExpType);
    }

    /**
     * 获取结果值
     * @param targetClass 用于封装数据的目标类型
     * @param <T> 目标类型
     * @return 映射结果
     * @throws InstantiationException 目标类型实例化失败时抛出此异常
     * @throws BeanHandlingException 目标类型赋值失败时抛出此异常
     */
    public <T> List<T> getResult(Class<T> targetClass) throws InstantiationException, BeanHandlingException {
        checkBeforeGetResult();
        this.isAlreadFetchResult = true;
        BeanHandler beanHandler = coreProfile.getBeanHandler();
        List<T> result = new ArrayList<>();
        for (Object srcObj : srcCol) {
            T item = ClassHelper.newInstance(targetClass);
            Iterator<ExpType> selectIt = nodeStack.iterator();
            while (selectIt.hasNext()) {
                // 格式： selectExpType valExpType
                SelectExpType selectExpType = (SelectExpType) selectIt.next();
                ValExpType valExpType = (ValExpType) selectIt.next();
                // 取出表达式的值
                Object objVal = AntlrHelper.getExpVal(srcObj, valExpType);
                // 赋值
                beanHandler.setFieldVal(item, selectExpType.getSelectName(), objVal);
            }

            result.add(item);
        }

        return result;
    }

    /**
     * 获取map结果值
     * @return 映射结果
     */
    public List<Map<String, Object>> getMapResult() {
        checkBeforeGetResult();
        this.isAlreadFetchResult = true;
        List<Map<String, Object>> result = new ArrayList<>(srcCol.size());
        for (Object srcObj : srcCol) {
            Map<String, Object> item = new HashMap<>();
            Iterator<ExpType> selectIt = nodeStack.iterator();
            while (selectIt.hasNext()) {
                // 格式： selectExpType valExpType
                SelectExpType selectExpType = (SelectExpType) selectIt.next();
                ValExpType valExpType = (ValExpType) selectIt.next();
                // 取出表达式的值
                Object objVal = AntlrHelper.getExpVal(srcObj, valExpType);

                item.put(selectExpType.getSelectName(), objVal);
            }

            result.add(item);
        }

        return result;
    }

    /**
     * 获取结果前的校验
     */
    private void checkBeforeGetResult() {
        // 不考虑需要多次获取结果的情况
        if (isAlreadFetchResult) {
            throw new OqlExpResolvedException("结果已经被取出，请勿重复调用");
        }

        if (nodeStack.isEmpty()) {
            throw new OqlExpResolvedException("请先执行语法树遍历");
        }
    }

}
