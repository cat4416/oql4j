package com.cat.oqj4j.support;

import java.util.Collections;
import java.util.Set;

/**
 * 合法对象封装
 *
 * @author gwj
 */
public class LegalObjPack {

    /**
     * 是否全部符合
     */
    private boolean isAllSatisfied = false;
    /**
     * 合法对象集合
     */
    private Set<Object> legalObjs;

    /**
     * 是否全部符合
     * @return
     */
    public boolean isAllSatisfied() {
        return isAllSatisfied;
    }

    /**
     * 是否无合法对象
     * @return true表示无合法对象
     */
    public boolean isNoLegalObjs() {
        return isAllSatisfied ? false : (legalObjs == null ?  true : legalObjs.isEmpty());
    }


    /**
     * 转移为全部符合
     */
    public void transferAllSatisfied() {
        if (!isAllSatisfied) {
            isAllSatisfied = true;
            legalObjs = Collections.emptySet();
        }
    }

    /**
     * 如果达到合法数量转移为全部符合。
     * @param legalSize 合法对象数量
     * @return 转移结果。true表示全部转移为符合。
     */
    public boolean transferAllSatisfiedIf(int legalSize) {
        // 要求必须要有数量
        if (legalSize != 0 && legalSize == getLegalObjs().size()) {
            this.transferAllSatisfied();
        }
        return isAllSatisfied;
    }

    /**
     * 是否合法对象
     * @param obj
     * @return true表示合法对象
     */
    public boolean isIegalObj(Object obj) {
        // 如果是全部符合，则直接都属于合法对象
        return isAllSatisfied ? isAllSatisfied : getLegalObjs().contains(obj);
    }

    /**
     * 增加合法对象
     * @param obj
     */
    public void addIllegalObj(Object obj) {
        if (!isAllSatisfied) {
            getLegalObjs().add(obj);
        }
    }

    /**
     * 预计合法对象数量。
     * 注意：如果是全部符合的情况下，合法对象为-1。
     * @return 合法对象数量
     */
    public int expectLegalSize() {
        return isAllSatisfied ? -1 : getLegalObjs().size();
    }

    /**
     * 获取合法对象集合。
     * 如果集合不存在主动创建。
     * @return
     */
    private Set<Object> getLegalObjs() {
        if (legalObjs == null) {
            legalObjs = new IdentityHashSet<>();
        }
        return legalObjs;
    }
}
