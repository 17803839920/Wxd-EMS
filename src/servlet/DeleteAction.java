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

@WebServlet("/deleteAction")

public class DeleteAction extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext<PersonService> ac = new ApplicationContext<>();
        PersonService ps = ac.getBean("PersonService");
        String id = req.getParameter("id");
        Person person = new Person(id);
        ps.deletePerson(person);
        req.getRequestDispatcher("/queryAllPerson").forward(req, resp);
    }
}
