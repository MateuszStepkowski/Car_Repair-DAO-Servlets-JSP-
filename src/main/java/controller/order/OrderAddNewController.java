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

@WebServlet(name = "OrderAddNewController", urlPatterns = "/order/add")
public class OrderAddNewController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Order order = new Order();
            order.setReceiveDate(Date.valueOf(request.getParameter("receiveDate")));
            order.setPlannedStartDate(Date.valueOf(request.getParameter("plannedStartDate")));
            order.setStartDate(request.getParameter("startDate").length() < 1 ? null : Date.valueOf(request.getParameter("startDate")));
            order.setEndDate(request.getParameter("endDate").length() < 1 ? null : Date.valueOf(request.getParameter("endDate")));
            order.setEmployee(EmployeeDao.loadById(Integer.parseInt(request.getParameter("employee"))));
            order.setProblemDescription(request.getParameter("problemDescription"));
            order.setRepairDescription(request.getParameter("repairDescription"));
            order.setStatus(Status.valueOf(request.getParameter("status")));
            order.setVehicle(VehicleDao.loadById(Integer.parseInt(request.getParameter("vehicle"))));
            order.setClientCosts(Double.parseDouble(request.getParameter("clientCosts")));
            order.setPartsCost(Double.parseDouble(request.getParameter("partsCost")));
            order.setServiceCostPerHour();
            order.setHoursAmount(Double.parseDouble(request.getParameter("hoursAmount")));

            OrderDao.save(order);
            response.sendRedirect("/order/allOrders");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/order/allOrders");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
