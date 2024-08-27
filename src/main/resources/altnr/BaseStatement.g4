// 定义基本的表达式语法内容
grammar BaseStatement;


// 定义基本类型
baseType
    :   STRING      #StringVal
    |   NUMBER      #NumberVal
    |   BOOLEAN     #BooleanVal
    |   NULL        #NullVal
    |   fieldPlace  #FieldPlaceVal
    |   funPlace    #FunPlaceVal
    ;

// 定义自定义函数占位符
funPlace
    :  'f{' ID ('(' (baseType (',' baseType)*)? ')')?  '}'
    |  'F{' ID ('(' (baseType (',' baseType)*)? ')')?  '}'
    ;

// 定义字段取值占位符
fieldPlace: '${' idNest '}';

// 定义id嵌套
idNest:  ID ('.' ID)*;

STRING: ('"' | '\'') .*? ('"' | '\''); // 定义字符串，双引号与单引号都兼容

BOOLEAN: [tT][rR][uU][eE] | [fF][aA][lL][sS][eE]; // 布尔类型
NULL: [nN][uU][lL][lL]; // 空值

NUMBER
    :   '-'? INT '.' INT SNEXP?  // 匹配形式 1.35,1.35e-9,0.3
    |   '-'? INT SNEXP    // 匹配形式 1e10
    |   '-'? INT        // 匹配形式 -3
    ;
fragment INT: '0' | [1-9][0-9]*; // 如果0开头，就只能是单个0数字
fragment SNEXP: [Ee] [+\-]? INT;   // 科学计数法表达式 \-是对-转义


AND:  [aA][nN][dD] | '&&'; // and关键字
OR:  [oO][rR] | '||'; // or关键字
IN:  [iI][nN]; // in关键字
IS:  [iI][sS]; // is关键字
BETWEEN:  [bB][eE][tT][wW][eE][eE][nN]; // between关键字
NOT:  [nN][oO][tT]; // not关键字
AS:  [aA][sS]; // as关键字

EQ : '=';
GT: '>' ;
LT: '<' ;
GE: '>=';
LE: '<=';
NEQ: ('!=' | '<>');

COMMA : ','; // 定义逗号
ID  : [a-zA-Z][a-zA-Z0-9_]*; // 命名ID