package controller.reports;

import entity.Reports;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReportsController", urlPatterns = "/report")
public class ReportsController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String reportType = request.getParameter("reportType");

        response.sendRedirect("/report/"+reportType);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("reports", Reports.values());
        getServletContext().getRequestDispatcher("/WEB-INF/views/reports/chooseReport.jsp").forward(request, response);

    }
}
