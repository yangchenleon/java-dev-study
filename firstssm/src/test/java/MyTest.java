import beans.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springContext.xml"})

public class MyTest {
    @Autowired
    @Qualifier("user1")
    public User user;
    @Autowired
    IUserService service;

//    @Test
//    public void factoryTest() {
//        //模拟前端操作业务层
//        //客户端调用 业务层接口  --- 调用业务层实现类
//        ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
//        IUserService service = (UserServiceImpl) context.getBean("userServiceImpl");
//        Student student = (Student) context.getBean("student");
//        System.out.println(student);
//    }

    @Test
    public void annotaTest() {
        System.out.println(user);
    }

    @Test
    public void testService(){
        System.out.println(user);
        if(service.insert(user) > 0) {
            System.out.println("记录插入成功");
        } else {
            System.out.println("记录插入失败");
        }
    }
}
