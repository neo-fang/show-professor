# show-professor
记录完成“优选导师”项目的整个过程

第一步：完成一个hello-world程序

第二步：测试登录以及用户管理功能


项目描述：
SpringBoot + gradle导师信息网站
功能：在线展示导师信息、添加导师评论、redis缓存信息内容、SpringSecurity验证身份（管理员、老师、学生）、java爬虫爬取信息。升级版：使用tomcat部署。

项目需求分析：
一、功能需求：
1.	登录登出功能（SpringSecurity）
普通用户登录仅仅可以查看导师信息；
管理员用户登录具有对导师信息的一切增删改查的权限。
每个页面都包含登出功能
需要的页面：首页登录页面+已有用户展示页面

2.	导师信息展示功能（redis缓存）
对已有的导师信息分学校、分条目展示，每个条目中有一个老师，点击每个条目，转到单独的该老师的信息中；没有信息的老师显示提示：目前暂无该老师信息。
需要的页面：学校分类页面+某个学校导师条目页面+导师信息展示页面

3.	对导师评论功能
每个导师信息展示页面的下面应当加入对该老师的评论功能，管理员和用户都有该权限。
需要的页面：导师信息展示页面（具有导师评论功能）

4.	导师信息爬虫（如何处理对数据库的并发读写？）
程序运行过程中，创建另外几条线程爬取导师信息，存入数据库

二、页面设计：
	登录登出——首页登录页面+已有用户展示页面
	导师信息展示功能——学校分类页面+某个学校导师条目页面+导师信息展示页面
	导师评论功能——导师信息展示页面（具有导师评论功能）
	














第一阶段：学习使用SpringBoot+gradle创建简单web应用，理解SpringMvc的前后端分离的编码方式，并且学会Thymeleaf、数据库、jpa、SpringSecurity的使用
1.	任务：模仿企业博客项目——与Thymeleaf结合的创建、展示、修改用户的功能，学习使用MVC框架如何实现前端后端交互传输，学会用springboot搭建一个web应用项目的流程和结构。、
  
 
工程：工程文件保存在E:\springBoot\show-professor1.0中
2.	任务：学习Spring Data JPA中的常用接口（如CrudRespository），实现数据库集成；学习springboot与h2数据库、Mysql数据库的集成。
工程：工程文件保存在E:\springBoot\show-professor1.1中
3.	任务：学习在SpringBoot中集成SpringSecurity，以及用SpringSecurity实现登录和访问过程中的权限控制。
工程：工程文件保存在E:\springBoot\show-professor1.2中
亮点：SpringMvc原理、SpringSecurity机制
第二阶段：学习使用SpringBoot+Redis实现缓存功能
1.	任务：学习springboot+JPA+mysql+redis缓存实现从数据库中读取数据时的缓存功能。
工程：工程文件保存在E:\springBoot\myRedis（Redis缓存+JPA+Mysql）中
2.	亮点：redis缓存机制
第三阶段：学习使用java爬虫爬取导师信息数据
1.	任务：学习springboot+webmagic爬虫+mysql+jdbc实现java爬虫，从网页爬取导师信息，使用jdbc存入mysql数据库的操作。
工程：工程文件保存在E:\springBoot\javaSpider（webmagicSpider+mysql+jdbc）中
2.	亮点：重复url过滤——布隆过滤器；反爬虫机制——设置agent、代理机制、ip池等、网页去重——simHash算法（余弦相似度）

第四阶段：各个模块整合
1、导师信息展示模块
1.	导师信息展示页面home.html原型










			图3 home.html		 图4 teachers.html        
2.	导师信息展示模块功能
如上图3所示，当用户点击某一学校时，页面跳转到该学校对应的所有老师的展示页面teachers.html，该页面会从数据库中选择出所有该学校的老师，形成导师列表，该列表中展示了导师简单信息。
3.	工程：
工程文件在：E:\springBoot\projectTest\show-professor2.0（导师信息展示模块—jpa+mysql）工程和E:\springBoot\projectTest\show-professor2.1（redis缓存+导师信息展示模块）工程中。

2、登录和注册
1.	登录注册页面login.html原型



	登录成功




	登录失败
	
	图1 login.html                   	 图2 home.html
2.	页面功能：用户通过该页面实现登录或者注册
预期功能：
	登录
后台根据用户输入的用户名和密码匹配用户身份是否为管理员（设计一个管理员正好和密码），若非管理员，则从存储用户账户密码的数据库中读取信息并匹配，登录成功则进入主页页面home.html，失败则停留在登录注册页面，并显示失败信息。
	注册
用户输入用户名和密码后，点击注册，即可注册为普通用户，保存在数据库中。
工程文件在E:\springBoot\projectTest\show-professor2.2（登录+导师信息+redis缓存）中。

