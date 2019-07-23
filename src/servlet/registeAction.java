package servlet;

import bean.User;
import dao.UserDao;
import dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registeAction")
public class registeAction extends HttpServlet {
    public registeAction() {
        super();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserDao dbUser = new UserDaoImpl();
        try {
            if (dbUser.findUser(user)) {
                //已经存在用户
                response.sendRedirect("/regist.jsp");
            } else {
                dbUser.insertUser(user);
                response.sendRedirect("/login.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
