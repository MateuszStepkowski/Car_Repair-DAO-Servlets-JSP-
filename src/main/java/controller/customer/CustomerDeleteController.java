package controller.customer;

import entity.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerDeleteController", urlPatterns = "/customer/delete")
public class CustomerDeleteController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            int id = Integer.parseInt(request.getParameter("customerID"));
            CustomerDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/customer/allCustomers");
    }
}
