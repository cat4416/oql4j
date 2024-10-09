// 用于解析update更新数据的表达式语法
grammar UpdateStatement;
// 引入基本语法
import BaseStatement;

// 解析处理。增加EOF声明，匹配输入的全文。
parse
     : stat EOF
     ;

// 定义声明语法
stat
     : update (',' update)*
     ;

// update语法
update
     : updateField EQ baseType #baseAssign
     ;

// 更新字段
updateField: fieldPlace;

WS  : [ \t\r\n]+ -> skip;  // 跳过空格、制表符、回车符和换行符