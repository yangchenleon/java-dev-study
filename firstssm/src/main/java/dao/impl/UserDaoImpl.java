package dao.impl;

import beans.User;
import dao.IUserDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import utils.JDBCUtils;

import java.util.List;

@Repository
public class UserDaoImpl implements IUserDao {
    // 使用操作数据库的一个模板  JDBCTemplate  需要 和数据库相关的东西
    // driver url username password
    // 创建JdbcTemplate这个对象需要一个参数，是 DataSource
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

    @Override
    public User findUserByNameAndPwd(User user) {
        String sql = "select * from user where " + "username = \'" + user.getUsername().toString() + "\' AND password = \'" + user.getPassword().toString() + "\'";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users.get(0);

    }

    @Override
    public int insert(User user) {
        String sql = "INSERT INTO USER VALUES(?,?)"; //设置的预编译语句格式
        Object[] values = new Object[]{user.getUsername(), user.getPassword()};
        int result = template.update(sql, values);
        return result;
    }
}