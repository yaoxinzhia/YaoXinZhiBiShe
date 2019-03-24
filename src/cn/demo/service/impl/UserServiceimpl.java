package cn.demo.service.impl;

import cn.demo.dao.impl.Userdaoimpl;
import cn.demo.domain.User;
import cn.demo.service.UserService;

import java.util.List;

public class UserServiceimpl implements UserService {
    Userdaoimpl dao = new Userdaoimpl();

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }
}
