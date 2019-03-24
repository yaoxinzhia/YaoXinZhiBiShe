package cn.demo.dao.impl;

import cn.demo.dao.Userdao;
import cn.demo.domain.User;
import cn.demo.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import java.util.List;

public class Userdaoimpl implements Userdao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        String sql = "select * from users";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<>(User.class));

        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from users where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(User user) {
        String sql = "insert into users values(null,?,?,?)";
        template.update(sql, user.getUsername(), user.getPassword(), user.getEmailadress());
    }
}
