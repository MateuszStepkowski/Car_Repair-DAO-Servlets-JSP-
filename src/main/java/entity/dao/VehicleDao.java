package entity.dao;

import entity.Vehicle;
import service.DbService;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VehicleDao {



    public static void save(Vehicle vehicle) throws Exception {
        if (vehicle.getId() == null) {
            addNew(vehicle);
        } else {
            update(vehicle);
            return;
        }
    }

    public static void delete(Vehicle vehicle) throws Exception {
        String query = "DELETE FROM vehicle WHERE id = ?";

        List<String> params = new ArrayList<>();
        params.add(String.valueOf(vehicle.getId()));

        DbService.executeQuery(query, params);
        vehicle.setId(0);
    }

    private static void addNew(Vehicle vehicle) throws Exception {
        String query = "INSERT INTO vehicle VALUES(null,?,?,?,?,?,?)";

        List<String> params = new ArrayList<>();
        params.add(vehicle.getModel());
        params.add(vehicle.getBrand());
        params.add(String.valueOf(vehicle.getProductionYear()));
        params.add(vehicle.getRegistrationNumber());
        params.add(String.valueOf(vehicle.getNextInspection()));
        params.add(String.valueOf(vehicle.getCustomer().getId()));

        Integer id = DbService.insertIntoDataBase(query, params);
        vehicle.setId(id);
    }

    private static void update(Vehicle vehicle) throws Exception {
        String query = "UPDATE vehicle SET model = ?, brand = ?, " +
                "production_year = ?, registration_number = ?, " +
                "next_inspection = ?, customer_id = ? " +
                "WHERE id = ? ";

        List<String> params = new ArrayList<>();
        params.add(vehicle.getModel());
        params.add(vehicle.getBrand());
        params.add(String.valueOf(vehicle.getProductionYear()));
        params.add(vehicle.getRegistrationNumber());
        params.add(String.valueOf(vehicle.getNextInspection()));
        params.add(String.valueOf(vehicle.getCustomer().getId()));
        params.add(String.valueOf(vehicle.getId()));

        DbService.executeQuery(query, params);
    }



    public static Vehicle loadById(Integer id) throws Exception {
        String query = "SELECT * FROM vehicle WHERE id = ? ";

        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));

        Vehicle vehicle = null;
        List<Map<String,String>> data = DbService.getData(query, params);

        for(Map<String,String> row : data) {
            vehicle = createFromDB(row);
        }
        return vehicle;
    }

    public static List<Vehicle> loadAll() throws Exception {
        String query = "SELECT * FROM vehicle";
        List<Vehicle> vehicles = new ArrayList<>();
        List<Map<String, String>> data = DbService.getData(query, null);
        for(Map<String,String> row : data) {
            vehicles.add(createFromDB(row));
        }
        return vehicles;
    }

    private static Vehicle createFromDB(Map<String, String> row) throws Exception {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(Integer.parseInt(row.get("id")));
        vehicle.setBrand(row.get("brand"));
        vehicle.setModel(row.get("model"));
        vehicle.setProductionYear(Integer.parseInt(row.get("production_year")));
        vehicle.setRegistrationNumber(row.get("registrationNumber"));
        vehicle.setNextInspection(Date.valueOf(row.get("next_inspection")));
        vehicle.setCustomer(CustomerDao.loadById(Integer.parseInt(row.get("customer_id"))));
        return vehicle;
    }

    public static List<Vehicle> loadByCustomerId(Integer id) throws Exception {
        String query = "SELECT * FROM vehicle WHERE customer_id = ?";

        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));

        List<Vehicle> vehicles = new ArrayList<>();
        List<Map<String,String>> data = DbService.getData(query, params);

        for (Map<String, String> row : data) {
            vehicles.add(createFromDB(row));
        }
        return vehicles;
    }

}
