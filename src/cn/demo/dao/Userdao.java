package cn.demo.dao;

import cn.demo.domain.User;

import java.util.List;

/**
 * 操作用户类接口
 */

public interface Userdao {

    // 查找所有用户
    public List<User> findAll();

    //查找指定用户
    User findUserByUsernameAndPassword(String username, String password);

    // 增加用户
    void add(User user);


}
