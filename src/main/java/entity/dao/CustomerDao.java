package entity.dao;

import entity.Customer;
import service.DbService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerDao {

    public static void save(Customer customer) throws Exception {
        if(customer.getId() == null) {
            addNew(customer);
        } else {
            update(customer);
            return;
        }
    }


    public static void delete(Customer customer) throws Exception{
        String query = "DELETE FROM customer WHERE id = ?";

        List<String> params = new ArrayList<>();
        params.add(String.valueOf(customer.getId()));

        DbService.executeQuery(query, params);
        customer.setId(0);
    }



    private static void addNew(Customer customer) throws Exception {
        String query = "INSERT INTO customer VALUES (null,?,?,?,?)";

        List<String> params = new ArrayList<>();
        params.add(customer.getForename());
        params.add(customer.getSurname());
        params.add(customer.getPhoneNumber());
        params.add(String.valueOf(customer.getBirthDate()));

        Integer id = DbService.insertIntoDataBase(query, params);
        customer.setId(id);
    }

    private static void update(Customer customer) throws Exception {
        String query = "UPDATE customer SET forename = ?, surname = ?, phone_number = ?, birth_date = ? " +
                "WHERE id = ? ";

        List<String> params = new ArrayList<>();
        params.add(customer.getForename());
        params.add(customer.getSurname());
        params.add(customer.getPhoneNumber());
        params.add(String.valueOf(customer.getBirthDate()));
        params.add(String.valueOf(customer.getId()));

        DbService.executeQuery(query,params);
    }

    public static Customer loadById(Integer id) throws Exception {
        String query = "SELECT * FROM customer WHERE id = ?";

        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));

        Customer customer = null;
        List<Map<String, String>> data = DbService.getData(query, params);

        for(Map<String, String> row : data) {
            customer = createFromDB(row);
        }
        return customer;
    }

    public static List<Customer> loadAll() throws Exception {
        String query = "SELECT * FROM customer";

        List<Customer> customers = new ArrayList<>();

        List<Map<String,String>> data = DbService.getData(query, null);

        for(Map<String, String> row : data) {
            customers.add(createFromDB(row));
        }
        return customers;
    }

    private static Customer createFromDB(Map<String, String> row) {
        Customer customer = new Customer();
        customer.setId(Integer.parseInt(row.get("id")));
        customer.setForename(row.get("forename"));
        customer.setSurname(row.get("surname"));
        customer.setPhoneNumber(row.get("phone_number"));
        customer.setBirthDate(Timestamp.valueOf(row.get("birth_date")));
        return customer;
    }

    public static List<Customer> loadBySurname(String surname) throws Exception {
        String query = "SELECT * FROM customer WHERE surname = ?";

        List<Customer> customers = new ArrayList<>();
        List<String> params = new ArrayList<>();
        params.add(surname);
        List<Map<String, String>> data = DbService.getData(query, params);

        for(Map<String, String> row : data) {
            customers.add(createFromDB(row));
        }
        return customers;
    }
}
