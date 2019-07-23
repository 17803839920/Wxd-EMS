package servlet;

import bean.Person;
import service.PersonService;
import util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/queryPersonDetailAction")

public class QueryPersonDetailAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受ID，查询并转发
        String id = req.getParameter("id");
        if (id != null) {
            ApplicationContext<PersonService> ac = new ApplicationContext<PersonService>();
            PersonService ps = ac.getBean("PersonService");
            Person person = new Person();
            person.setId(id);
            Person p = ps.selectPersonById(person);
            req.setAttribute("person", p);//将联系人存入request并转发
            req.getRequestDispatcher("/detail.jsp").forward(req, resp);
        } else {
            //未传参
            System.out.println("没传递参数");
            resp.sendRedirect("/list.jsp");
        }
    }
}
