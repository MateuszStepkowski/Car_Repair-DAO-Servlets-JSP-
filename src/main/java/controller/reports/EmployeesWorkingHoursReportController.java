package controller.reports;

import entity.EmployeeWorkingHoursReport;
import service.EmployeesWorkingHoursReportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "EmployeesWorkingHoursReportController", urlPatterns = "/report/employeesWorkingHours")
public class EmployeesWorkingHoursReportController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<EmployeeWorkingHoursReport> reportList =
                    EmployeesWorkingHoursReportService
                            .generate(Date.valueOf(request.getParameter("fromDate")), Date.valueOf(request.getParameter("toDate")));


            request.setAttribute("fromDate", request.getParameter("fromDate"));
            request.setAttribute("toDate", request.getParameter("toDate"));
            request.setAttribute("reportList", reportList);

            getServletContext().getRequestDispatcher("/WEB-INF/views/reports/employeesWorkingHoursReport.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/report");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/views/reports/employeesWorkingHoursReport.jsp").forward(request, response);

    }
}
