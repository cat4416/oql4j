// 用于解析select映射查询的表达式语法
grammar SelectStatement;
// 引入基本语法
import BaseStatement;

// 解析处理。增加EOF声明，匹配输入的全文。
parse
     : stat EOF
     ;

// 定义声明语法
stat
     : select (',' select)*
     ;

select
     : baseType            #DirectSelect
     | baseType idNest     #AliasSelect
     | baseType AS idNest  #AsAliasSelect
     ;

WS  : [ \t\r\n]+ -> skip;  // 跳过空格、制表符、回车符和换行符