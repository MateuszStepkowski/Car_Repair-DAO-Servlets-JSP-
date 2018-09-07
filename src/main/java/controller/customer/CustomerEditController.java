package controller.customer;

import entity.Customer;
import entity.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "CustomerEditController", urlPatterns = "/customer/edit")
public class CustomerEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("customerID"));

        Customer customer = new Customer();
        customer.setId(id);
        customer.setForename(request.getParameter("forename"));
        customer.setSurname(request.getParameter("surname"));
        customer.setPhoneNumber(request.getParameter("phoneNumber"));
        customer.setBirthDate(Date.valueOf(request.getParameter("birthDate")));
        try {
            CustomerDao.save(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/customer/details?customerID="+id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
