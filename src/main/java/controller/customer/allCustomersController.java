package controller.customer;

import entity.Customer;
import entity.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "allCustomersController", urlPatterns = "/customer/allCustomers")
public class allCustomersController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Customer> customers = null;
        try {
            customers= CustomerDao.loadAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("customers", customers);
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/allCustomers.jsp").forward(request, response);


    }
}
