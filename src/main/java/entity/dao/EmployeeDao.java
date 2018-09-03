package entity.dao;

import entity.Employee;
import service.DbService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeDao {


    public static void save(Employee employee) throws Exception {
        if (employee.getId() == null) {
            addNew(employee);
        } else {
            update(employee);
            return;
        }
    }

    public static void delete(Employee employee) throws Exception {
        String query = "DELETE FROM employee WHERE id = ? ";

        List<String> params = new ArrayList<>();
        params.add(String.valueOf(employee.getId()));

        DbService.executeQuery(query, params);
        employee.setId(0);
    }


    private static void addNew(Employee employee) throws Exception {
        String query = "INSERT INTO employee VALUES(null,?,?,?,?,?,?)";

        List<String> params = new ArrayList<>();
        params.add(employee.getForename());
        params.add(employee.getSurname());
        params.add(employee.getAddress());
        params.add(employee.getPhoneNumber());
        params.add(employee.getNote());
        params.add(String.valueOf(employee.getHourSalary()));

        Integer id = DbService.insertIntoDataBase(query, params);
        employee.setId(id);
    }

    private static void update(Employee employee) throws Exception {
        String query = "UPDATE employee SET forename = ?, surname = ?, " +
                "address = ?, phone_number = ?, note = ?, hour_salary = ? " +
                "WHERE id = ?";

        List<String> params = new ArrayList<>();
        params.add(employee.getForename());
        params.add(employee.getSurname());
        params.add(employee.getAddress());
        params.add(employee.getPhoneNumber());
        params.add(employee.getNote());
        params.add(String.valueOf(employee.getHourSalary()));
        params.add(String.valueOf(employee.getId()));

        DbService.executeQuery(query, params);
    }


    public static Employee loadById(Integer id) throws Exception {
        String query = "SELECT * FROM employee WHERE id = ? ";

        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));

        Employee employee = null;
        List<Map<String, String>> data = DbService.getData(query, params);

        for (Map<String, String> row : data) {
            employee = createFromDB(row);
        }
        return employee;
    }

    public static List<Employee> loadAll() throws Exception {
        String query = "SELECT * FROM employee";

        List<Employee> employees = new ArrayList<>();
        List<Map<String, String>> data = DbService.getData(query, null);

        for (Map<String, String> row : data) {
            employees.add(createFromDB(row));
        }
        return employees;
    }


    private static Employee createFromDB(Map<String, String> row) {
        Employee employee = new Employee();
        employee.setId(Integer.parseInt(row.get("id")));
        employee.setForename(row.get("forename"));
        employee.setSurname(row.get("surname"));
        employee.setAddress(row.get("address"));
        employee.setNote(row.get("note"));
        employee.setPhoneNumber(row.get("phone_number"));
        employee.setHourSalary(Double.parseDouble(row.get("hour_salary")));
        return employee;
    }


}
