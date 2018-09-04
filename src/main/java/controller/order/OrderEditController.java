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

@WebServlet(name = "OrderEditController", urlPatterns = "/order/edit")
public class OrderEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("orderID"));


            Order order = OrderDao.loadById(id);
            order.setReceiveDate(Date.valueOf(request.getParameter("receiveDate")));
            order.setPlannedStartDate(Date.valueOf(request.getParameter("plannedStartDate")));
            order.setStartDate(Date.valueOf(request.getParameter("startDate")));
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
            response.sendRedirect("/order/details?orderID="+id);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/order/allOrders");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("orderID"));
        Order order = null;

        try {
            order = OrderDao.loadById(id);
            request.setAttribute("employees", EmployeeDao.loadAll());
            request.setAttribute("vehicles", VehicleDao.loadAll());
            request.setAttribute("statuses", Status.values());
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("order", order);
        getServletContext().getRequestDispatcher("/WEB-INF/views/forms/orderEditForm.jsp").forward(request, response);
    }

}

