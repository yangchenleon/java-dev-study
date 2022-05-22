package dao;

import beans.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IUserDao {
    public User findUserByNameAndPwd(User user);

    public int insert(User user);

    public List<User> findAll();
}
