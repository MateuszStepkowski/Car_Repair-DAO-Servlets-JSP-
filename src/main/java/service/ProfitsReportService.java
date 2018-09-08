package service;

import entity.Order;
import entity.ProfitsReport;
import entity.dao.OrderDao;

import java.sql.Date;
import java.util.List;

public class ProfitsReportService {

    public static ProfitsReport generate(Date fromDate, Date toDate) throws Exception {

        ProfitsReport profitsReport = new ProfitsReport();

        List<Order> orders = OrderDao.loadByStartDateFromTO(fromDate, toDate);

        for (Order order : orders) {
            profitsReport.setClientCosts(profitsReport.getClientCosts() + order.getClientCosts());
            profitsReport.setPartsCost(profitsReport.getPartsCost() + order.getPartsCost());
            profitsReport.setServiceCost(profitsReport.getServiceCost() + order.getHoursAmount() * order.getServiceCostPerHour());
            profitsReport.setHoursAmount(profitsReport.getHoursAmount() + order.getHoursAmount());
        }

        profitsReport.setProfit();
        profitsReport.setAvgCostPerHour();

        return profitsReport;

    }
}