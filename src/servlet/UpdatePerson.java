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

@WebServlet("/updatePerson")

public class UpdatePerson extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext<PersonService> ac = new ApplicationContext<>();
        PersonService ps = ac.getBean("PersonService");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phoneNumber");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        Person person = new Person(id, name, phoneNumber, sex, email, address, birthday);
        int i = ps.updatePerson(person);
        System.out.println(i);
        req.getRequestDispatcher("/queryAllPerson").forward(req, resp);
    }
}
