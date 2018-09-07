package controller.employee;

import entity.Employee;
import entity.dao.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "allEmployeesController", urlPatterns = "/employee/allEmployees")
public class allEmployeesController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Employee> employees = null;
        try {
            employees= EmployeeDao.loadAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("employees", employees);
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/allEmployees.jsp").forward(request, response);

    }
}
