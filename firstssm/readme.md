当前状态，本来是想结合最后整合ssm的版本最为结束的，但是搞不出来，
不知道是我的问题还是原本的也不行，还得运行老师看看

现在能用resource中dao+sqlMapConfig能测试数据库的操作MybatisUser/RegistTest
（不是tomcat）和 springContext+springmvc运行tomcat完成数据库操作（不是Mybatis），但是不行结合两个
，如@Repository得放到daoimpl上tomcat可以运行，但是整合的是要放在接口上的

整合版的文件是springBean（代替Context）+sqlMapConfig2，mvc一样的，然后web.xml也有不同，注释掉了。
反正我现在不想整了，先写着记录下，怕忘了到哪了，好回忆。

很快哦，第二天我就测试了，老师的压根就没实现，视频里最后怎么样这里还是怎么样的

---
最后还是解决了，tmd命名规则害人啊，用的大写的SqlMap，我改成小写的，但是文件里涉及到了，我记得我改了，
但是后来为了避免错误直接重新复制粘贴。找问题也一直默认这里没问题的，晕。中途反复替换文件，替换另一个成功的这个也成功运行，
但是替换回去问题不在了，一直以为是编译的问题，把class删了又删，ide重启好几遍，其实一直都是这个大小写的问题。
总之其实一开始就可以运行的，区别就在于一个字母的大小写，大无语。（其实仔细看的话，这里的文件名问题标红的，但由于不是编译问题，
不会在文件下有波浪线的，但报错信息又指向java文件夹上而非resource上，没关注这个，焯。）

---
现在老师的问题也解决了，这个问题我遇到过，就是他乱起名字，网页提交了但是找不到地方提交，所以始终进不到regist方法里；
还是不行，因为数据库的数据是直接写到Bean里的，不是从properties读的，我先后改了数据库和密码就成功了。

---
项目暂告一段落：

说下结构：
1. java下几个文件夹：beans、dao、service、controller、utils
   1. beans就是基础的对象：Register、Students、User（可看成一个东西，下统一用user）
   2. dao最底层数据库连接：接口IUserDao类、实现接口的类存在impl（可以没有）
   3. service即一些基础的功能，把数据库操作包装起来
   4. controller给前端结果处理的模块，可调用service的方法实现各种功能
   5. utils就是工具集合，如再底层数据库的连接关闭集合成一个类，当然还有其他
2. dao、service开始：
   1. 直接用数据库连接的函数写在daoImpl里
   2. 但是每个方法都要这个写一遍有冗余，遂把数据库连接的冗余部分放到DatabaseUtil中，再进一步把数据库信息提取为database.properties，为此设置ConfigManager用于从中获取数据
   3. 更进一步，2步骤采用别人写好的JDBC模板类JDBCUtils
   4. service没啥意思，当前就是再dao函数套一层
   5. 为了实现工厂模式，有springContext扫描器和实例定义，标注有@service、@repository的类再其他地方就可以用@Autowired注入实例而不用new
3. 下面开始controller
   1. 这一步需结合tomcat，webapp也动起来
   2. controller中的@RequestMapping表示访问到括号内的地址要执行的方法，方法会执行各种操作，可返回一个页面
   3. 为了连通web和controller，有mvc告诉web：controller在哪里我号给他处理，它返回的页面要在哪获取并渲染
   4. 那web如何获取mvc的这些信息呢，写在web.xml里了
4. 进入mybatis
   1. 从此dao不需要实现，impl文件夹可以删了，Utils里数据相关的也删了，其他不变
   2. 其实也是要实现的，不过写在resource下面的dao里了，相较而言简单太多而且不用在意语法问题
   3. 那数据库链接呢，也写在resource里面sqlMapConfig，以后数据库相关的都访问这个文件这就行，注意需要把dao实现放到里面
   4. 这里的测试可以参照MybatisRegistTest，交给sqlsession进行实际数据库操作
5. 整合三大件
   1. 把mybatis整进tomcat里而不是测试
   2. 删了和增了一些，java那边没变化，resource中Context（未删）改为Bean、sqlMapConfig大部分改写移动到Bean中，把sqlsession也写进去
   3. web.xml设置了起始页重设
   4. 还有一些看不懂有啥用，区别有点大

总的来说为了保留个版本特性，挺乱的，可简单分为三部分
1. 测试原始数据操作，dao下UserImpl、Context，可在MyTest、tomcat测试
2. 仅mybatis，和上面独立，无RegistImpl、增resource下dao、configbak，可在MybatisRegistTest测试。和上面可同时进行
3. 整合：无RegistImpl、resource下Bean、config

### TMD，我不知道我他妈不睡觉在这写这些狗屁，好像一个弱智，关键没人看懂我在写什么，我自己都看不懂