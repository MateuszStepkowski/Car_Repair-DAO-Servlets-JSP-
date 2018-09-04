package controller.order;

import entity.Order;
import entity.dao.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderDetails", urlPatterns = "/order/details")
public class OrderDetails extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("orderID"));
        Order order = null;

        try {
            order = OrderDao.loadById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("order", order);
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/orderDetails.jsp").forward(request, response);
    }

    }

