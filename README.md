# 豆瓣爬虫项目 #
##一、项目的组成
项目采用SpringMVC结构，主要结构和介绍如下：
> java文件夹，程序主要组成，实现逻辑
*  `utils`：  工具类文件夹      
*  `start`：  启动类文件夹  
*  `service`：  服务类文件夹  
*  `entity`： 实体类文件夹  
*  `repository`： 存储类文件夹  
>resources文件夹，配置数据库的连接信息池和日志的打印
* `movieinfo.properties` 配置一些需要手动输入的字段
##二、java文件夹内子文件夹具体结构介绍
### 1.`utils`（工具类文件夹）
* `GetPageContentUtil` 获取网页上下文信息的工具类
* `ParseContentUtil`  用于解析网页的工具类，封装后供网页上下文解析接口实现类调用
* `RegexUtil` 抽取出一个正则表达式工具类，供解析页面上下文工具类调用调用
* `LoadProperties` 用于加载配置类文件的工具类
* `JDBCUtil` MySQL连接和执行代码，手写JDBC工具类实现CRUD操作
### 2.`start`（启动类文件夹）
* `StartGetMovieInfo` 电影信息获取启动类
* `StartGetMovieList` 电影排行榜信息启动类
### 3.`service`（服务类文件夹）
* `IDownloadPageService` 页面信息下载的接口类
* `IProcessPageService`  网页上下文文件解析的接口类
* `IStorageService`  数据存储接口，用于将数据存储到数据库中
####3.1 `impl` (服务类接口实现文件夹)
* `DownloadPageServiceImpl` 页面信息下载接口的实现类
* `ProcessPageServiceImpl`  网页上下文文件解析接口的实现类
* `StorageServiceImpl` 数据存储接口的实现类
### 4.`entity`（实体类文件夹）
* `MovieInfo` 记录电影详情页的实体类