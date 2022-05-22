package service;

import beans.Register;

import java.util.List;

public interface IRegisterService {
    //插入数据方法
    public int insert(Register register);

    //查找方法
    public List<Register> findAll();
}
