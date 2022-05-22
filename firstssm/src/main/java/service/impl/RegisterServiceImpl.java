package service.impl;

import beans.Register;
import dao.IRegisterDao;
import service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements IRegisterService {
    @Autowired
    IRegisterDao dao;

    @Override
    public int insert(Register register) {
        return dao.insert(register);
    }

    @Override
    public List<Register> findAll() {
        return dao.findAll();
    }
}
