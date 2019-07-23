package servlet;


import bean.User;
import dao.UserDao;
import dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginAction")
public class LoginAction extends HttpServlet {
    public LoginAction() {
        super();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String validationCode = req.getParameter("code");
        String code = (String) req.getSession().getAttribute("validationCode");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        session.setAttribute("username", username);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        /**
         * 判断登陆条件
         * 用户存在且验证码输入正确
         * */
        UserDao dbUser = new UserDaoImpl();
        try {
            if (dbUser.findUser(user) && code.equals(validationCode)) {
                resp.sendRedirect("queryAllPerson");
            } else {
                resp.sendRedirect("/login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

