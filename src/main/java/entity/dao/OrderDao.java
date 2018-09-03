package entity.dao;

import entity.Order;
import entity.Status;
import service.DbService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderDao {


    public static void save(Order order) throws Exception {
        if (order.getId() == null) {
            addNew(order);
        } else {
            update(order);
        }
    }

    private static void addNew(Order order) throws Exception {
        String query = "INSERT INTO orders VALUES(null,?,?,?,null,?,?,?,?,?,?,?,?,?)";
        List<String> params = new ArrayList<>();

        params.add((order.getReceiveDate()).toString());
        params.add(order.getPlannedStartDate().toString());
        params.add(order.getStartDate().toString());
        params.add(String.valueOf(order.getEmployee().getId()));
        params.add(order.getProblemDescription());
        params.add(order.getRepairDescription());
        params.add(order.getStatus().toString());
        params.add(String.valueOf(order.getVehicle().getId()));
        params.add(String.valueOf(order.getClientCosts()));
        params.add(String.valueOf(order.getPartsCost()));
        params.add(String.valueOf(order.getServiceCostPerHour()));
        params.add(String.valueOf(order.getHoursAmount()));

        order.setId(DbService.insertIntoDataBase(query, params));
    }

    private static void update(Order order) throws Exception {
        String query = "UPDATE order SET " +
                "receive_date = ?, planned_start_date = ?, start_date = ?, end_date = ?, " +
                "employee_id = ?, problem_description = ?, repair_description = ?, status = ?, " +
                "vehicle_id = ?, customer_costs = ?, parts_cost = ?, service_cost_per_hour = ?, " +
                "hours_amount = ? " +
                "WHERE id = ?";
        List<String> params = new ArrayList<>();

        params.add((order.getReceiveDate()).toString());
        params.add(order.getPlannedStartDate().toString());
        params.add(order.getStartDate().toString());
        params.add(order.getEndDate().toString());
        params.add(String.valueOf(order.getEmployee().getId()));
        params.add(order.getProblemDescription());
        params.add(order.getRepairDescription());
        params.add(order.getStatus().toString());
        params.add(String.valueOf(order.getVehicle().getId()));
        params.add(String.valueOf(order.getClientCosts()));
        params.add(String.valueOf(order.getPartsCost()));
        params.add(String.valueOf(order.getServiceCostPerHour()));
        params.add(String.valueOf(order.getHoursAmount()));
        params.add(String.valueOf(order.getId()));

        DbService.executeQuery(query, params);
    }


    public static void delete(int id) throws Exception {
        String query = "DELETE FROM order WHERE id = ?";
        List<String> params = new ArrayList<>();

        params.add(String.valueOf(id));
        DbService.executeQuery(query, params);
    }

    public static List<Order> findAll() throws Exception {
        String query = "SELECT * FROM order";

        return resultList(query, null);
    }

    public static Order loadById(int id) throws Exception {
        String query = "SELECT * FROM order WHERE id = ?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));

        List<Map<String, String>> data = DbService.getData(query, params);


        return createFromDB(data.get(0));


    }

    private static Order createFromDB(Map<String, String> row) throws Exception {
        Order order = new Order();

        order.setId(Integer.parseInt(row.get("id")));
        order.setReceiveDate(Timestamp.valueOf(row.get("receive_date")));
        order.setPlannedStartDate(Timestamp.valueOf(row.get("planned_start_date")));
        order.setStartDate(Timestamp.valueOf(row.get("start_date")));
        order.setEndDate(row.get("end_date") == null ? null : Timestamp.valueOf(row.get("end_date")));
        order.setEmployee(EmployeeDao.loadById(Integer.parseInt(row.get("employee_id"))));
        order.setProblemDescription(row.get("problem_description"));
        order.setRepairDescription(row.get("repair_description"));
        order.setStatus(Status.valueOf(row.get("status")));
        order.setVehicle(VehicleDao.loadById(Integer.parseInt(row.get("vehicle_id"))));
        order.setClientCosts(Double.parseDouble(row.get("client_costs")));
        order.setPartsCost(Double.parseDouble(row.get("parts_cost")));
        order.setServiceCostPerHour();
        order.setHoursAmount(Double.parseDouble(row.get("hours_amount")));

        return order;
    }

    public static List<Order> loadByVehicleId(int id) throws Exception {
        String query = "SELECT * FROM order WHERE vehicle_id = ?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));

        return resultList(query, params);
    }

    public static List<Order> loadByEmployeeId(int id) throws Exception {
        String query = "SELECT * FROM order WHERE employee_id = ?";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));

        return resultList(query, params);
    }

    public static List<Order> loadByStartDateBetween(Timestamp startDate, Timestamp endDate) throws Exception {
        String query = "SELECT * FROM order WHERE (start_date BETWEEN ? AND ?);";
        List<String> params = new ArrayList<>();
        params.add(startDate.toString());
        params.add(endDate.toString());

        List<Map<String, String>> data = DbService.getData(query, params);

        List<Order> results = new ArrayList<>();
        for (Map<String, String> row : data) {
            results.add(createFromDB(row));
        }

        return results;
    }

    public static List<Order> loadInRepairByEmployeeId(int id) throws Exception {
        String query = "SELECT * FROM order WHERE employee_id = ? AND status = 'IN_REPAIR'";
        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));

        return resultList(query, params);
    }

    

    private static List<Order> resultList(String query, List<String> params) throws Exception {
        List<Map<String, String>> data = DbService.getData(query, params);
        List<Order> results = new ArrayList<>();

        for (Map<String, String> row : data) {
            results.add(createFromDB(row));
        }

        return results;
    }
}
