package controller.vehicle;

import entity.Order;
import entity.Vehicle;
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

@WebServlet(name = "VehicleDetailsController", urlPatterns = "/vehicle/details")
public class VehicleDetailsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("vehicleID"));
        Vehicle vehicle = null;
        List<Order> vehicleOrdersHistory = new ArrayList<>();

        try {
            vehicle = VehicleDao.loadById(id);
            vehicleOrdersHistory = OrderDao.loadByVehicleId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("vehicle", vehicle);
        request.setAttribute("vehicleOrdersHistory", vehicleOrdersHistory);
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/vehicleDetails.jsp").forward(request, response);
    }
}
