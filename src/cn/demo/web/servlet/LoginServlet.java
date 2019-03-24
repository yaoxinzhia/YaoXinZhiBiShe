package cn.demo.web.servlet;

import cn.demo.dao.impl.Userdaoimpl;
import cn.demo.domain.User;
import cn.demo.service.UserService;
import cn.demo.service.impl.UserServiceimpl;
import cn.demo.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;

/**
 * 登录servlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置编码
        req.setCharacterEncoding("utf-8");

        //获取用户输入的验证码
        String verifycode = req.getParameter("verifycode");
        //验证码效验
        HttpSession session = req.getSession();
        String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
        //确保验证码一致性
        session.removeAttribute("CHECKCODE_SERVER");

        //判断验证码输入与session中的值是否一致
        if(!checkcode_server.equalsIgnoreCase(verifycode)){
            //验证码不正确
            //提示信息
            req.setAttribute("login_msg","验证码错误！");
            //跳转到登录页面
            req.getRequestDispatcher("/login.jsp").forward(req,resp);

            return;
        }

        // 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 封装User对象
        User loginuser = new User();
        loginuser.setUsername(username);
        loginuser.setPassword(password);

        // 调用service判断User对象是否正确
        Userdaoimpl service = new Userdaoimpl();
        User login = service.findUserByUsernameAndPassword(username,password);

//        DataSource ds = JDBCUtils.getDataSource();

        // 判断user对象
        if(login != null){
            // 登录成功
            // 跳转页面
            resp.sendRedirect(req.getContextPath() + "/librarymaininterface.jsp");
            //将用户信息存入session中
            req.getSession().setAttribute("USER",login);
        } else {
            // 登录失败
            // 提示信息
            req.setAttribute("login_msg","用户名或者密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
