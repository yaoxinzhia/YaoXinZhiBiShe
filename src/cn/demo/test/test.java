package cn.demo.test;

import cn.demo.dao.impl.Userdaoimpl;
import cn.demo.domain.User;
import cn.demo.service.UserService;
import cn.demo.service.impl.UserServiceimpl;
import org.junit.Test;

import java.util.List;

public class test {

     // 测试users类
    @Test
    public void Userstest(){
        User user = new User();
        user.setPassword("dd0");
        System.out.println(user);
    }

     // 测试impl中的findall方法
    @Test
    public void impl_findall_test(){
        Userdaoimpl test = new Userdaoimpl();
        List<User> all = test.findAll();
        for(User user : all){
            System.out.println(user);
        }
    }

    // 测试impl中的findUserByUsernameAndPassword方法
    @Test
    public void impl_findUserByUsernameAndPassword_test(){
        Userdaoimpl test = new Userdaoimpl();
        User lisi = test.findUserByUsernameAndPassword("lisi", "123123");
        System.out.println(lisi);
    }

    // 测试impl中的add方法
    @Test
    public void impl_add_test(){
        User wangwu = new User();
        Userdaoimpl test = new Userdaoimpl();
        wangwu.setUsername("wangwu");
        wangwu.setPassword("123123");
        wangwu.setEmailadress("444444");
        test.add(wangwu);
        List<User> list = test.findAll();
        for(User user : list){
            System.out.println(user);
        }
    }

    // 测试service中的login方法
    @Test
    public void service_login_test(){
        User lala = new User();
        lala.setUsername("lisi");
        lala.setPassword("123123");
        System.out.println(lala);
        UserService service = new UserServiceimpl();
        User login = service.login(lala);
        System.out.println(login);
    }

    @Test
    public void userServiceimpl_test(){
        UserServiceimpl userServiceimpl = new UserServiceimpl();
        List<User> all = userServiceimpl.findAll();
        for(User user : all){
            System.out.println(user);
        }
    }
}
