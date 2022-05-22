package service.impl;

import beans.User;
import dao.IUserDao;
//import dao.impl.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IUserService;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao dao;

    @Override
    public User findUserByNameAndPwd(User user) {
        return dao.findUserByNameAndPwd(user);
    }

    @Override
    public int insert(User user) {
        return dao.insert(user);
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }
}
