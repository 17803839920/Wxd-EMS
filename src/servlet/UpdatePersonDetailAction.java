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

@WebServlet("/updatePersonDetailAction")
public class UpdatePersonDetailAction extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        ApplicationContext<PersonService> ac = new ApplicationContext<>();
        PersonService ps = ac.getBean("PersonService");

        Person person = new Person(id);
        person = ps.selectPersonById(person);
        req.setAttribute("p", person);
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }
}
