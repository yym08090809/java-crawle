#java 爬虫学习
## HttpClient
### 简介
&ensp;&ensp;&ensp;&ensp;网络爬虫就是用程序帮助我们访问网络上的资源，我们一直以来都是使用HTTP协议访问互联网的网页，网络爬虫需要编写程序，在这里使用同样的HTTP协议访问网页。
这里我们使用Java的HTTP协议客户端 HttpClient这个技术，来实现抓取网页数据。

**pom.xml**
~~~xml
    <!-- HttpClient -->
        <dependency>
            <groupId>org.apache.httpcomponents</groupId>
            <artifactId>httpclient</artifactId>
            <version>4.5.3</version>
        </dependency>
    
        <!-- 日志 -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>1.7.25</version>
        </dependency>
~~~
**log4j.porperties**
~~~porperties
og4j.rootLogger=DEBUG,A1
log4j.logger.cn.itcast = DEBUG

log4j.appender.A1=org.apache.log4j.ConsoleAppender
log4j.appender.A1.layout=org.apache.log4j.PatternLayout
log4j.appender.A1.layout.ConversionPattern=%-d{yyyy-MM-dd HH:mm:ss,SSS} [%t] [%c]-[%p] %m%n
~~~
### Get请求
* 不带参数（对应代码 et01）
* 带参数（Get02）
### Post请求
 * 不带参数（对应代码 Post01）
 * 带参数（Post02）
### 连接池(HttpClientDemo)
 &ensp;&ensp;&ensp;&ensp;如果每次请求都要创建HttpClient，会有频繁创建和销毁的问题，可以使用连接池来解决这个问题。
 测试以下代码，并断点查看每次获取的HttpClient都是不一样的。
### 请求参数（RequestsParams）
&ensp;&ensp;&ensp;&ensp;有时候因为网络，或者目标服务器的原因，请求需要更长的时间才能完成，我们需要自定义相关时间。
## Jsoup
### 简介
&ensp;&ensp;&ensp;&ensp;jsoup 是一款Java 的HTML解析器，可直接解析某个URL地址、HTML文本内容。它提供了一套非常省力的API，可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据。

jsoup的主要功能如下：
1.	从一个URL，文件或字符串中解析HTML；
2.	使用DOM或CSS选择器来查找、取出数据；
3.	可操作HTML元素、属性、文本；
先加入Jsoup依赖：
~~~xml
<!--Jsoup-->
<dependency>
    <groupId>org.jsoup</groupId>
    <artifactId>jsoup</artifactId>
    <version>1.10.3</version>
</dependency>
<!--测试-->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
</dependency>
<!--工具-->
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>3.7</version>
</dependency>
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.6</version>
</dependency>
~~~
### jsoup解析
1. 解析URL（一般不用）
2. 解析字符串
3. 解析文件
### 使用dom方式遍历文档
#### 元素获取
1.	根据id查询元素getElementById
2.	根据标签获取元素getElementsByTag
3.	根据class获取元素getElementsByClass
4.	根据属性获取元素getElementsByAttribute

#### 元素中获取数据
1.	从元素中获取id
2.	从元素中获取className
3.	从元素中获取属性的值attr
4.	从元素中获取所有属性attributes
5.	从元素中获取文本内容text
#### test




