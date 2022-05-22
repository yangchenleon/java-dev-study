package service;

import beans.User;

import java.util.List;

public interface IUserService {
    public User findUserByNameAndPwd(User user);

    public int insert(User user);

    public List<User> findAll();
}
