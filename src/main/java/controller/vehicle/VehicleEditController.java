package controller.vehicle;

import entity.Vehicle;
import entity.dao.CustomerDao;
import entity.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "VehicleEditController", urlPatterns = "/vehicle/edit")
public class VehicleEditController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int customerID = Integer.parseInt(request.getParameter("customerID"));
        int id = Integer.parseInt(request.getParameter("vehicleID"));
        Vehicle vehicle = new Vehicle();
        vehicle.setId(id);
        vehicle.setModel(request.getParameter("model"));
        vehicle.setBrand(request.getParameter("brand"));
        vehicle.setProductionYear(Integer.parseInt(request.getParameter("productionYear")));
        vehicle.setRegistrationNumber(request.getParameter("registrationNumber"));
        vehicle.setNextInspection(Date.valueOf(request.getParameter("nextInspection")));
        try {
            vehicle.setCustomer(CustomerDao.loadById(customerID));
            VehicleDao.save(vehicle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/vehicle/details?vehicleID="+id);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
