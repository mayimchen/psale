开发环境：
tomact6.0.29
mysql5.1.51

部署之后，到src之下,打开Jdbcinfo，将数据库建好，然后将密码设置好，为空的话不填就好了。
建表语句在WebRoot下的mydoc里,sqlv0.1.txt里就是建表语句。

加过权限控制，所以先在数据库里加条管理员记录,具体权限可以参照version0.2.txt中的文档介绍

先建立一个数据库:sale

insert user(userid,username,passwd,existstate,management)values('888888','测试人员','123456',0,5);



