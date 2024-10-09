# 一、简介
## 1.1 介绍
oql4j 全称 Object Query Language For Java，即java版本的对象查询语言，支持使用编写查询语言快速的搜索出符合条件的对象，简化对象的处理操作。
目前支持where条件过滤、select映射查询和update字段更新等操作。

# 二、使用指南
## 2.1 依赖说明
- 基于jdk8版本
- 依赖antlr4包（pom依赖自动引入）
- 依赖commons-beanutils包（pom依赖自动引入）


## 2.2 使用主代码
```
OqlClientBuilder oqlClientBuilder = new OqlClientBuilder();
OqlClient oqlClient = oqlClientBuilder.build();
```
然后就可以使用oqlClient对象，进行各种where条件的操作，select的映射查询，例如操作oqlClient.doWhereFilter(...)、oqlClient.doSelect(...)<br/>
OqlClient接口的默认实现类是DefaultOqlClientImpl，此类是线程安全的，所以**oqlClient对象可作为单例在整个项目中使用**。 


## 2.3 Where条件过滤使用案例
```
OqlClientBuilder oqlClientBuilder = new OqlClientBuilder();
OqlClient oqlClient = oqlClientBuilder.build();
// 原数据
Map<String, String> srcMap = new HashMap<>();
srcMap.put("name", "李明");
// 编写oql语法
String whereOqlExp = " ${name} is not null ";
// name字段不为空，判断是否存在这样的原数据。
boolean result = oqlClient.doWhereExists(whereOqlExp, srcMap);
// 打印的结果为true
System.out.println(result);
```
更多的使用demo，可参考代码的测试用例：com.cat.oqj4j.core.OqlClientlWhereTest


## 2.4 Select映射查询使用案例
```
OqlClientBuilder oqlClientBuilder = new OqlClientBuilder();
OqlClient oqlClient = oqlClientBuilder.build();
// 原数据
PersonTest person = new PersonTest();
person.setName("张三");
person.setIsMan(true);
person.setAge(36);
// 编写oql语法
String selectOqlExp = " ${age} myAge, ${isMan} as knownGender, ${name} as myName, ${addr.province} as  myAddr.province,  ${addr.city} myAddr.city";
// 执行select映射，将映射结果赋值到MyPersonTest对象。
MyPersonTest result = oqlClient.doSelect(selectOqlExp, person, MyPersonTest.class);
```
更多的使用demo，可参考代码的测试用例：com.cat.oqj4j.core.OqlClientlSelectTest


## 2.5 Update字段更新使用案例
```
OqlClientBuilder oqlClientBuilder = new OqlClientBuilder();
OqlClient oqlClient = oqlClientBuilder.build();
// 原数据
PersonTest person = new PersonTest();
person.setName("张三");
person.setIsMan(true);
person.setAge(36);
// 编写oql语法
String updateOqlExp = " ${age} = '37', ${name} = '刘三', ${isMan} = ${isMan}, ${addr.city} = '惠州市' ";
// 执行update更新，返回更新的记录数。
int result = oqlClient.doUpdate(updateOqlExp, person);
```
更多的使用demo，可参考代码的测试用例：com.cat.oqj4j.core.OqlClientlSelectTest

## 2.6 语法检查工具使用
为方便快速检查语法格式是否正确，提供了静态的检查工具类com.cat.oqj4j.support.GrammarCheckHelper，方便执行语法检查。
使用代码如下：
```
String selectOqlExp = "F{StrLen(${name})}, true isMan, 26 as age, ${hobby} myHobby";
boolean result = GrammarCheckHelper.verifySelectExp(selectOqlExp);
```
更多的使用demo，可参考代码的测试用例：com.cat.oqj4j.support.GrammarCheckHelperTest

# 三、语法规则
## 3.1 语法基础
### 3.1.1 基本类型说明：
| 类型 | 类型demo |
| --- | --- |
| 字符串 | 有单双引号的内容都是属于字符串，例如 "name"、'name' 表示常量name |
| 数值 | 数字类的都属于数值类型，包括整数和小数以及科学计数法，例如99、9993.66、-321、 1e3|
| 布尔 | 布尔值类型，只有真和假，并且不区分大小写，例如true、True、TRUE、false、False、FALSE|
| null | null类型，并且不区分大小写，例如null、Null、NULL|

### 3.1.2 语法概览：
| 关键字 | 说明 | 语法demo | 详细说明 |
| --- | --- | --- | --- |
| ${} | 取值操作 | ```${name}``` 表示取对象的name属性 | [3.1.2.1 取值操作](#3121-取值操作) |
| F{} | 执行函数 | ```F{StrLen(${name})}``` 表示取出对象的name属性值并且执行StrLen函数 | [3.1.2.2 执行函数](#3122-执行函数) |

#### 3.1.2.1 取值操作
- 使用```${}```来表示，例如```${name}``` 表示取对象的name属性值，支持嵌套取值，使用.来分割，
  例如```${addr.city}```表示取对象的addr属性下的city属性，即取出addr属性后，再操作addr对象取出city属性。
  <br/><br/>
- 注意嵌套取值时，如果上层属性必为null，则直接返回null值，例如嵌套取city属性时，city的上层属性addr为null，则取到的city属性也为null。
  <br/><br/>
- 取值操作是基本语法，支持在select映射语法、where条件语法中使用。

#### 3.1.2.2 执行函数
- 用于执行预定义和自定义的函数，使用F{}关键字，关键字不区分大小写， F{}、f{} 都能识别。
  <br/><br/>
- 格式为```F{funName}、F{funName()}、F{funName(arg1,arg2...)}``` 均支持，默认都会传操作集合的原对象和遍历的当前对象这两个参数，
  有需要的可以额外追加参数，并且追加的参数可以为常量参数也可以为动态取值参数。
  例如： ```F{StrLen(${name})}``` 表示取出对象的name属性值作为参数，执行StrLen函数。
  例如： ```F{CastInt(F{StrLen(${age})})} > 2``` 表示取出对象的age属性值，取得字符串长度，然后再转换为int类型，并对函数结果进行大于2判断。
  <br/><br/>
- 取值操作是基本语法，支持在select映射语法、where条件语法中使用。
  例如在select映射语法的使用： ```F{IfNull(${name}, '未知')}```
  例如在where条件语法的使用： ```F{StrLen(${name})} > 2```
  <br/><br/>
- 框架预定义的函数如下（支持自定义函数，具体可查看 [5.1 自定义函数](#51-自定义函数)）：

  | 函数名 | 功能 | 所需参数 | 详细说明 |
    | --- | --- | --- | --- |
  | StrLen | 字符串长度 | StrLen(arg1)，arg1：用于判断字符串长度的参数 | 将传入的参数转换为字符串，统计并返回字符串长度。如果参数为null，则返回长度为0。 |
  | If | 三元表达式条件处理 | If(arg1,arg2,arg3)，arg1：用于判断条件的真假，arg2：条件为真时的返回值，arg3：条件为假时的返回值 | 用于判断arg1参数，如果为真则返回arg2参数，反之返回arg3。数值0和false字符串都属于假，1和true字符串则属于真(false和true字符串不区分大小写)。 |
  | IfNull | null结果时取默认值 | IfNull(arg1,arg2)，arg1：主参数值，arg2：默认值 | 如果arg1参数不为null则返回此值，否则返回arg2参数。  |
  | CastStr | 转换为字符串 | CastStr(arg1)，arg1：用于转换为字符串的参数 | 将传入的参数转换为字符串，如果参数为null，则返回null。 |
  | CastBigDec | 转换为BigDecimal | CastBigDec(arg1)，arg1：用于转换为BigDecimal的参数 | 将传入的参数转换为BigDecimal，如果参数为null，则返回null。 |
  | CastInt | 转换为Integer | CastInt(arg1)，arg1：用于转换为Integer的参数 | 将传入的参数转换为Integer，如果参数为null，则返回null。 |
  | CastLong | 转换为Long | CastLong(arg1)，arg1：用于转换为Long的参数 | 将传入的参数转换为Long，如果参数为null，则返回null。 |
  | CastByte | 转换为Byte | CastByte(arg1)，arg1：用于转换为Byte的参数 | 将传入的参数转换为Byte，如果参数为null，则返回null。 |
  | CastFloat | 转换为Float | CastFloat(arg1)，arg1：用于转换为Float的参数 | 将传入的参数转换为Float，如果参数为null，则返回null。 |
  | CastDouble | 转换为Double | CastDouble(arg1)，arg1：用于转换为Double的参数 | 将传入的参数转换为Double，如果参数为null，则返回null。 |
  | CastChar | 转换为Character | CastChar(arg1)，arg1：用于转换为Character的参数 | 将传入的参数转换为Character，如果参数为null或者为""字符串，则返回null，长度大于1则转换报错。 |
  | CastBool | 转换为Boolean | CastBool(arg1)，arg1：用于转换为Boolean的参数 | 将传入的参数转换为Boolean，如果参数为null，则返回null。数值0和false字符串都属于假，1和true字符串则属于真(false和true字符串不区分大小写)。 |
  | ClassSimpleName | 获取Class简短名称 | ClassSimpleName(arg1)，arg1：用于获取Class字节码对象的简短名称的参数 | 将传入的参数去除Class字节码对象并获取简短名称，如果参数为null，则返回"null"字符串。 |
  | NotExistNull | 判断全部参数都不为null | NotExistNull(arg1,arg2,arg3...)，传入需要判断的参数，不限制参数数量 | 将传入的参数逐一判断，如果都不为null则返回true，反之false。如果没有传入任何参数，则返回true。 |
  | Incr | 累加运算 | Incr(arg1,arg2)，arg1：被加数，arg2：累加步长 | 对arg1进行求和运算，即arg1+arg2，如果arg2参数为null，则默认步长为1。 |
  | Dncr | 累减运算 | Dncr(arg1,arg2)，arg1：被减数，arg2：累减步长 | 对arg1进行减法运算，即arg1-arg2，如果arg2参数为null，则默认步长为1。 |

- 框架预定义的函数使用demo，可参考代码的测试用例：com.cat.oqj4j.core.OqlClientFunTest

## 3.2 Where条件语法
### 3.2.1 语法概览：
| 关键字 | 说明 | 语法demo | 详细说明 |
| --- | --- | --- | --- |
| and | 并且条件 | ```${name} = '张三' and ${age} > 20``` 表示名称为张三并年龄大于20 | [3.2.1.1 并且条件](#3211-并且条件) |
| or | 或者条件 | ```${name} = '张三' or ${name} = '李四'``` 表示名称为张三或者李四 | [3.2.1.2 或者条件](#3212-或者条件) |
| () | 括号运算 | ```(${name} = '张三' or ${name} = '李四') and ${age} > 20``` 表示先判断名称可为张三或者李四，然后再判断年龄大于20岁 | [3.2.1.3 括号运算](#3213-括号运算) |
| in | 同时指定多个或者条件 | ```${name} in ('张三','李四')``` 表示名称为张三或者李四 | [3.2.1.4 同时指定多个或者条件](#3214-同时指定多个或者条件) |
| between | 范围条件 | ```${age} between 20 and 30``` 表示年龄在[20,30]范围内 | [3.2.1.5 范围条件](#3215-范围条件) |
| is null | 等于空 | ```${name} is null``` 表示姓名为null 等价于 ```${name} = null``` | [3.2.1.6 等于空](#3216-等于空) |
| is not null | 不等于空 | ```${name} is not null``` 表示姓名不为null 等价于 ```${name} != null``` | [3.2.1.7 不等于空](#3217-不等于空) |


#### 3.2.1.1 并且条件
- 对多个条件进行交集处理，and关键字不区分大小写，即and、And、AND 都能识别。
- 支持用 && 代替and关键字。例如：```${name} = '张三' and ${age} > 20``` 等价于 ```${name} = '张三' && ${age} > 20```
- and的优先级比or要高。


#### 3.2.1.2 或者条件
- 对多个条件进行并集处理，or关键字不区分大小写，即or、Or、OR 都能识别。
- 支持用 || 代替or关键字。例如：```${name} = '张三' or ${age} > 20``` 等价于 ```${name} = '张三' || ${age} > 20```
- or的优先级小于and。


#### 3.2.1.3 括号运算
- 用于提升运算优先级，使用\(\)将表达式括起来，括号内的表达式将优先执行，常用于在and、or条件下进行配套使用。
- 括号表达式的运算优先级比and、or都高


#### 3.2.1.4 同时指定多个或者条件
- 当存在or参数时，可以使用in关键字来实现，关键字不区分大小写，即in、In、IN都能识别。  
- 格式为 ```keyName in (arg1,arg2,arg3,arg4...)```，arg参数可以是常量参数，也可以是动态取值参数，
  例如 ```${name} in ('李白', ${formerName})``` 表示判断对象的name属性值是否为 李白 或者为此对象的formerName属性。
- in内的arg参数不限制数量，并且可以同时为各种类型数据，例如可以同时有字符串类型、数值类型等。  


#### 3.2.1.5 范围条件
- 当需要判断范围时，可以使用between关键字，关键字不区分大小写，即between、Between、BETWEEN等都能识别。
- 格式为``` keyName between arg1 and arg2、keyName between arg1 && arg2 ```， 大于等于arg1 并且小于等于 arg2，等价于 >=arg1 and <=arg2。
  例如  ```${age} between 20 and 30 ```表示年龄在[20,30]范围内，20、21、29、30等均符合，用&&写法则为```${age} between 20 && 30 ```

#### 3.2.1.6 等于空
- 用于判断值是否为null，使用 is null 关键字，关键字不区分大小写， is、IS、null、Null、NULL等都能识别。
- 格式为 ```keyName is null```， 例如  ```${name} is null``` 表示name属性值为null的判断，也等价于 ```${name} = null``` 表达式。

#### 3.2.1.7 不等于空
- 用于判断值是否不为null，使用 is not null 关键字，关键字不区分大小写， is、IS、not、Not、null、Null、NULL等都能识别。
- 格式为 ```keyName is not null```， 例如  ```${name} is not null``` 表示name属性值不为null的判断，也等价于 ```${name} != null``` 表达式。


### 3.2.2 其他说明：
- where条件支持使用比较符合，具体符合和比较规则，详见 [4.1 比较说明](#41-比较说明)。
- 当使用单指作为条件时，必须是布尔类型，或者是可以转换为布尔类型的数字或字符串，否则语法执行将报错。布尔类型转换详见[4.2 布尔类型的转换](#42-布尔类型的转换)。


## 3.3 Select映射语法
### 3.3.1 使用格式：
- 直接写需要映射的字段，字段间使用英文逗号分隔，例如： name1, name2, name3, name4 ...

### 3.3.2 指定映射别名：
- 默认不指定的情况下，则直接用原字段名称，例如： ${name1}, ${name2} 表示取原对象的name1和name2属性，并映射赋值到目标对象的name1和name2属性。<br/><br/>
  如果是使用${}动态取值，默认情况下映射到目标对象的名称为取值字段名，例如${name} 表示取原对象的name属性，并映射赋值到目标对象的name属性。<br/><br/>
  如果是F{}函数，默认情况下映射到目标对象的名称为函数名，例如F{ClassSimpleName(${name})} 表示取原对象的name属性，并执行ClassSimpleName函数后，将结果映射赋值到目标对象的ClassSimpleName属性。
  <br/><br/>
- 使用空格方式指定。例如：${name1} fatherName, ${name2} motherName 表示取原对象的name1和name2属性，并映射赋值到目标对象的fatherName和motherName属性。
  <br/><br/>
- 使用AS关键字指定，并且as关键字不区分大小写。例如：${name1} AS fatherName, ${name2} as motherName 表示取原对象的name1和name2属性，并映射赋值到目标对象的fatherName和motherName属性。
  <br/><br/>

### 3.3.3 结合Where条件过滤使用：
- Select映射查询，是可以与Where条件过滤配套使用的，先执行Where条件过滤，将符合条件的数据再进行Select映射查询。OqlClient客户端有提供相应的api接口可调用。


## 3.4 Update更新语法
### 3.4.1 使用格式：
- 左边使用${}写需要更新的字段，右边为需要更新的值，多个字段间的更新使用英文逗号分隔，例如： ``` ${name1} = val1, ${name2} = val2, ${name3} = val3, ${name4} = val4 ... ```
- 右边的更新值可以是常量值，也可以是动态值或者是使用函数，例如： ``` ${age} = F{Incr(${age})}, ${name} = '刘三' ```

### 3.4.2 结合Where条件过滤使用：
- Update字段更新，是可以与Where条件过滤配套使用的，先执行Where条件过滤，将符合条件的数据再进行Update字段更新。OqlClient客户端有提供相应的api接口可调用。
- Update字段更新，返回结果为更新的记录条数，如果有使用Where条件，则返回的是过滤后的更新数据量。


# 四、约定说明
## 4.1 比较说明
- 目前支持的比较符号如下

  | 符号 | 含义 |
  | --- | --- |
  | \> | 大于 |
  | \< | 小于 |
  | = | 等于 |
  | \>= | 大于等于 |
  | \<= | 小于等于 |
  | != | 不等于 |
  | \<\> | 不等于 |

- 支持不同类型进行比较，规则如下：
    1. 判断相等时：如果是相同类型，判断相等时直接调用对象的equalse方法比较。
    2. 判断相等时：如果比较对象有null，则要求另外个对象也必须为null才相等，否则均为不等。
    3. 判断相等时：如果比较对象有个为布尔类型，另外个对象为字符串或数字时，则尝试统一转换为布尔值进行比较。0和false字符串都属于假，1和true字符串则属于真(false和true字符串不区分大小写)。
    4. 判断相等时：如果都是同属于Number子类，则转换为浮点型比较。
    5. 判断相等时：如果都是属于其中一种（java原始类型、字符串类型、Number子类），统一获取对象字符串进行比较。
    6. 判断大小时：如果存在有对象为null，属于无法比较大小，均返回false。
    7. 判断大小时：如果对象均为BigDecimal，转为BigDecimal进行比较
    8. 判断大小时：如果都是同属于Number子类，则转换为浮点型比较。
    9. 判断大小时：如果存在有对象为布尔值，属于无法比较大小，均返回false。
    10. 判断大小时：如果都是属于其中一种（java原始类型、字符串类型、Number子类），统一获取对象字符串进行比较(先比较长度，然后在比较asscii码值)。

## 4.2 布尔类型的转换
- 支持原生的布尔类型
- 如果是数字类型(Number子类)，0属于假可以转换为false布尔值，1属于真可以转换为true布尔值。
- 如果是字符串类型，"false"、'false'、"0"、'0'字符串属于假可以转换为false布尔值，"true"、'true'、"1"、'1'字符串属于真可以转换为true布尔值，并且字符串不区分大小写均可转换。

## 4.3 关键字大小写
除特殊情况外，默认情况下，关键字是不区分大小写的，均能识别，可根据需要自行选择使用。例如 And、AND、and、As、AS、as 等关键字都能识别。

## 4.4 线程安全
凡是对应的接口或者类名上有com.cat.oqj4j.annotation.ThreadSafe注解的，均表示此接口实现类和指定类都是线程安全的，生成的对象可作为单例使用。


# 五、高阶应用
## 5.1 自定义函数
- 除了使用框架预定义的函数以外，还支持自定义函数，方式如下:
  1. 实现com.cat.oqj4j.antlr.handler.FunHandler接口，或者继承com.cat.oqj4j.antlr.handler.AbstractFunHandler类。**注意实现类必须是线程安全的。**<br/>
  2. 注册函数，在OqlClientBuilder构造时注册，然后在表达式中通过F{}即可使用。
```
    OqlClientBuilder oqlClientBuilder = new OqlClientBuilder();
    // MyFunHandler是你自定义的函数类，根据需要更改类名。注意MyFunHandler是满足线程安全的。
    oqlClientBuilder.registerFunHandler(new MyFunHandler());
```

## 5.2 自定义bean操作
- 对bean的设值和赋值的操作，目前框架使用的是ApacheUtilsBeanHandler，此类是基于apache的commons-beanutils工具包的PropertyUtils类来实现，如果需要者可以自定义bean操作类，方式如下:
  1. 实现com.cat.oqj4j.support.BeanHandler接口。**注意实现类必须是线程安全的。**<br/>
  2. 设置bean操作器，在OqlClientBuilder构造时设置，后续对bean的操作都会自动用此操作器。
```
    OqlClientBuilder oqlClientBuilder = new OqlClientBuilder();
    // MyBeanHandler是你实现的bean操作器，根据需要更改类名。注意MyBeanHandler是满足线程安全的。
    oqlClientBuilder.setBeanHandler(new MyBeanHandler());
```


# 附加
## 源码管理
源码将发布在github上进行管理，同时在gittee进行放开查看。
- github地址（支持编辑）: https://github.com/cat4416/oql4j
- gitee地址（用于查看）：https://gitee.com/cat4416/oql4j

## maven仓库中心GAV坐标
```
<dependency>
    <groupId>io.github.cat4416</groupId>
    <artifactId>oql4j</artifactId>
    <version>2.1</version>
</dependency>
```
- 仓库中心版本号与源码版本同步，从2.1版本开始，都将支持在maven仓库中心下载依赖包。

## 作者联系方式：
- 微信号(wechat)：cat4416
- 邮箱：565335545@qq.com