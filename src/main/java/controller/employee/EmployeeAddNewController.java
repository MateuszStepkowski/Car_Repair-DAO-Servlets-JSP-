package controller.employee;

import entity.Employee;
import entity.dao.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeAddNewController", urlPatterns = "/employee/add")
public class EmployeeAddNewController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Employee employee = new Employee();
        employee.setForename(request.getParameter("forename"));
        employee.setSurname(request.getParameter("surname"));
        employee.setAddress(request.getParameter("address"));
        employee.setPhoneNumber(request.getParameter("phoneNumber"));
        employee.setNote(request.getParameter("note"));
        employee.setHourSalary(Double.parseDouble(request.getParameter("hourSalary")));
        try {
            EmployeeDao.save(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/employee/allEmployees");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
