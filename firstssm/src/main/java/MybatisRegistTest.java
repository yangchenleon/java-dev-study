import beans.Register;
import dao.IRegisterDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisRegistTest {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfigbak.xml");

        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        //3.使用工厂 生产SqlSession对象
        SqlSession session = factory.openSession();

        //4.使用SqlSession创建Dao接口的代理对象
        IRegisterDao registerDao = session.getMapper(IRegisterDao.class);

        Register register = new Register("33333", "xfds23"
                , "34", "语文", "男", "贡工",
                "1423@.qq.com");

        //5 .使用代理对象执行方法
        registerDao.insert(register);
        session.commit(true);

//        List<Register> rs = registerDao.findAll();
//        System.out.println(rs);

        //6.释放资源
        session.close();
        in.close();

    }
}
