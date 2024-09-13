// 用于解析where条件过滤的表达式语法
grammar WhereStatement;
// 引入基本语法
import BaseStatement;

// 解析处理。增加EOF声明，匹配输入的全文。
parse
     : stat EOF
     ;

// 定义声明语法
stat
     :  binaryExp                   #BinaryExpStat
     |  unaryExp                    #UnaryExpStat
     |  stat AND stat               #AndStat
     |  stat OR stat                #OrStat
     |  '(' stat ')'                #ParenStat
     ;


// 二元表达式
binaryExp
    :   baseType operator baseType        #BinaryCond
    ;

// 运算操作符类型
operator
    :   EQ
    |   GT
    |   LT
    |   GE
    |   LE
    |   NEQ
    ;

// 一元表达式
unaryExp
    :   baseType IN '('  baseType (',' baseType)* ')'    #InCond
    |   baseType BETWEEN baseType AND baseType           #BetweenCond
    |   baseType IS NULL                                 #NullCond
    |   baseType IS NOT NULL                             #NotNullCond
    |   baseType                                         #ValCond
    ;

WS  : [ \t\r\n]+ -> skip;  // 跳过空格、制表符、回车符和换行符