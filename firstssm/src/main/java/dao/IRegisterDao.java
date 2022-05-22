package dao;

import beans.Register;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
// 区别于IUserDao接口，这里就不用impl实现dao了，直接Mybatis整合到resource的下面
// 因此这里的impl的文件夹可以删除、utils下的JDBUtils模板也可以删除

@Repository
public interface IRegisterDao {
    public int insert(Register register);
    public List<Register> findAll();
}
