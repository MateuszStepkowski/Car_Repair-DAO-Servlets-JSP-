package controller.employee;

import entity.Employee;
import entity.dao.EmployeeDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeEditController", urlPatterns = "/employee/edit")
public class EmployeeEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("employeeID"));

        Employee employee = new Employee();
        employee.setId(id);
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
        response.sendRedirect("/employee/details?employeeID="+id);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("employeeID"));
        try {
            request.setAttribute("employee", EmployeeDao.loadById(id));
            request.getServletContext().getRequestDispatcher("/WEB-INF/views/forms/employeeEditForm.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/employee/details?employeeID="+id);
        }
    }
}
