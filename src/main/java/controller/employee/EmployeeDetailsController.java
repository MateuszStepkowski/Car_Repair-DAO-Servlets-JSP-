package controller.employee;

import entity.Employee;
import entity.Order;
import entity.dao.EmployeeDao;
import entity.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeDetailsController", urlPatterns = "/employee/details")
public class EmployeeDetailsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("employeeID"));
        Employee employee = null;
        List<Order> inRepairOrders = new ArrayList<>();
        List<Order> restOfOrders = new ArrayList<>();


        try {
            employee = EmployeeDao.loadById(id);
            inRepairOrders = OrderDao.loadInRepairByEmployeeId(id);
            restOfOrders = OrderDao.loadNotInRepairByEmployeeId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("employee", employee);
        request.setAttribute("inRepairOrders", inRepairOrders);
        request.setAttribute("restOfOrders", restOfOrders);
        getServletContext().getRequestDispatcher("/WEB-INF/views/employeeDetails.jsp").forward(request, response);

    }
}
