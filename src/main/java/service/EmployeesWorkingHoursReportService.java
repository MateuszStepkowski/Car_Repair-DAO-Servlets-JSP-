package service;

import entity.EmployeeWorkingHoursReport;
import entity.Order;
import entity.dao.EmployeeDao;
import entity.dao.OrderDao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EmployeesWorkingHoursReportService {

    public static List<EmployeeWorkingHoursReport> generate(Date fromDate, Date toDate) throws Exception {

        List<EmployeeWorkingHoursReport> employeesReportList = new ArrayList<>();

        EmployeeDao.loadAll().stream()
                .forEach(employee -> employeesReportList.add(new EmployeeWorkingHoursReport(employee)));

        List<Order> orders = OrderDao.loadByStartDateFromTO(fromDate, toDate);

        for (EmployeeWorkingHoursReport employeeReport:employeesReportList){

            orders.stream()
                    .filter(order -> order.getEmployee().getId() == employeeReport.getEmployeeID())
                    .forEach(order ->  employeeReport.setHoursAmount(employeeReport.getHoursAmount()+order.getHoursAmount()));

        }


        return employeesReportList;
    }

}
