package controller.reports;

import entity.ProfitsReport;
import service.ProfitsReportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ProfitsReportController", urlPatterns = "/report/profitsReport")
public class ProfitsReportController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            ProfitsReport profitsReport =
                    ProfitsReportService
                            .generate(Date.valueOf(request.getParameter("fromDate")), Date.valueOf(request.getParameter("toDate")));


            request.setAttribute("fromDate", request.getParameter("fromDate"));
            request.setAttribute("toDate", request.getParameter("toDate"));
            request.setAttribute("profitsReport", profitsReport);

            getServletContext().getRequestDispatcher("/WEB-INF/views/reports/profitsReport.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/report");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/views/reports/profitsReport.jsp").forward(request, response);


    }
}
