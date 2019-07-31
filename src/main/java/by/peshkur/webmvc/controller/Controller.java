package by.peshkur.webmvc.controller;

import by.peshkur.webmvc.entity.Customer;
import by.peshkur.webmvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    CustomerService customerService;


    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

/*    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);

        return "welcome"; //view
    }*/

    // /hello?name=kotlin
    @GetMapping("/hello")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "")
                    String name, Model model) {

        model.addAttribute("message", name);

        return "welcome"; //view
    }

    @GetMapping("/")
    public String listCustomers() {

        return "redirect:list";
    }

    @GetMapping("/list")
    public String list() {

        return "redirect:list";
    }



    @GetMapping("/TestDbServlet")
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // setup connection variables
        String user = "admin";
        String pass = "password";

        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres?useSSL=false&serverTimezone=UTC";
        String driver = "org.postgresql.Driver";

        // get connection to database
        try {
            PrintWriter out = response.getWriter();

            out.println("Connecting to database: " + jdbcUrl);

            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            out.println("SUCCESS!!!");

            myConn.close();

        }
        catch (Exception exc) {
            exc.printStackTrace();
            throw new ServletException(exc);
        }
    }
}
