package cn.demo.service;

import cn.demo.domain.User;

import java.util.List;

/**
 *  service层user接口
 */
public interface UserService {

    // 查找所有用户
    public List<User> findAll();

    // 用户登录
    User login(User user);

    // 增加用户
    void addUser(User user);
}
