package controller.customer;

import entity.Customer;
import entity.Order;
import entity.Vehicle;
import entity.dao.CustomerDao;
import entity.dao.OrderDao;
import entity.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerDetailsController", urlPatterns = "/customer/details")
public class CustomerDetailsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("customerID"));
        Customer customer = null;
        List<Vehicle> customerVehicles= new ArrayList<>();
        List<Order> customerOrders = new ArrayList<>();


        try {
            customer = CustomerDao.loadById(id);
            customerVehicles = VehicleDao.loadByCustomerId(id);
            customerOrders = OrderDao.loadByCustomerId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("customer", customer);
        request.setAttribute("customerVehicles", customerVehicles);
        request.setAttribute("customerOrders", customerOrders);
        getServletContext().getRequestDispatcher("/WEB-INF/views/customerDetails.jsp").forward(request, response);
        
    }
}
