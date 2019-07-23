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
import java.util.List;

@WebServlet("/queryAllPerson")

public class QueryAllPerson extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext<PersonService> ac = new ApplicationContext<>();
        PersonService ps = ac.getBean("PersonService");
        List<Person> personList = ps.selectAllPerson();
        req.setAttribute("persons", personList);

        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}
