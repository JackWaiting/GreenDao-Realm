# GreenDao-Realm
Analysis GreenDao&amp;Realm

##Demo效果

我们通过Demo使用GreenDao&Realm数据库对相同的数据进行1、10、100、1000、10000、100000条数据同时添加、删除、查询（id,name,age3个字段）观察其性能的真实对比，其它条件完全保持一致，仅计算数据库增删改查的时间。 

通过记录大量数据取平均值，记录如下：

![](https://github.com/JackWaiting/GreenDao-Realm/blob/master/images/greendao%26realm07.png.png)

从这张表中体现出的现象: 

在小量数据的查询与删除等操作中，两者的差距基本可以忽略不计,早超过同时插入、删除、查询1000条以上的数据分析得出

GreenDao在删除操作中，占明显优势，而Realm在添加与查询方面优于GreenDAO。

##使用推荐

由于GreenDao在3.0.1后的使用极其方便，并且使用的习惯与拓展性、稳定性优于Realm，推荐使用GreenDao.

如果你的项目中对添加与查询操作要求极高的话，推荐使用Realm，但它目前相对不稳定，官方也在持续优化中，需留意官网并实时替换新版本。

##项目结构
![](https://github.com/JackWaiting/GreenDao-Realm/blob/master/images/greendao%26realm08.png)
##具体内容链接：

http://blog.csdn.net/zhanggang740/article/details/52164715
