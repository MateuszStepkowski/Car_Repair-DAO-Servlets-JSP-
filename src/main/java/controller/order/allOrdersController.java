package controller.order;

import entity.Order;
import entity.Status;
import entity.dao.EmployeeDao;
import entity.dao.OrderDao;
import entity.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "allOrdersController", urlPatterns = "/order/allOrders")
public class allOrdersController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Order> orders = null;
        try {
            orders = OrderDao.findAll();
            request.setAttribute("employees", EmployeeDao.loadAll());
            request.setAttribute("vehicles", VehicleDao.loadAll());
            request.setAttribute("statuses", Status.values());
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("orders", orders);
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/allOrders.jsp").forward(request, response);

    }
}
