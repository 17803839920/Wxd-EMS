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

@WebServlet(
        name = "addPersonAction",
        urlPatterns = "/addPersonAction"
)
public class AddPersonAction extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phoneNumber");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        Person person = new Person(name, phoneNumber, sex, email, address, birthday);
        ApplicationContext<PersonService> ac = new ApplicationContext<PersonService>();
        PersonService personService = ac.getBean("PersonService");
        int result = personService.addPerson(person);
        if (result == 0) {
            //正常运行
            resp.sendRedirect("/addPersonSuccess.jsp");
        } else {
            resp.sendRedirect("/add.jsp?errorMsg=" + result);
        }
    }
}
