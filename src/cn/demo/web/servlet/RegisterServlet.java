package cn.demo.web.servlet;

import cn.demo.domain.User;
import cn.demo.service.impl.UserServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 注册servlet
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");

        //获取用户输入的验证码
        String verifycode = req.getParameter("verifycode");
        //获取session中的验证码
        HttpSession session = req.getSession();
        String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
        //确保验证码一致性
        session.removeAttribute("CHECKCODE_SERVER");

        //判断验证码是否一致
        if(!verifycode.equalsIgnoreCase(checkcode_server)){
            //验证码不正确
            //提示信息
            req.setAttribute("relogin_msg","验证码错误！");
            //跳转到注册页面
            req.getRequestDispatcher("/register.jsp").forward(req,resp);

            return;
        }

        //获取用户输入的用户名，密码，再次输入的密码，邮箱
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repassword = req.getParameter("repassword");
        String email = req.getParameter("email");

        //邮箱基本验证
        if(!(email.endsWith("@qq.com")||(email.endsWith("@163.com")||(email.endsWith("@126.com"))))){
            //邮箱格式不正确
            //提示信息
            req.setAttribute("relogin_msg","请检查所输入的邮箱格式");
            //跳转到注册界面
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }

        //判断输入的密码和再次输入的密码是否一致
        if(!password.equals(repassword)){
            //不一致
            //提示信息
            req.setAttribute("relogin_msg","输入的密码不一致，请重新输入");
            //跳转到注册页面
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }

        //基本验证通过，开始注册用户
        //封装user类
        User user = new User(username,password,email);
        //调用adduser方法注册
        UserServiceimpl userServiceimpl = new UserServiceimpl();
        userServiceimpl.addUser(user);
        //跳转至等待界面，随后跳转至登录界面
        req.getRequestDispatcher("/wait.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
