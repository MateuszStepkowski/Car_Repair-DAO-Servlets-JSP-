<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../default/header.jsp"%>

<h3>Choose report:</h3>

<form action="/report" method="post">


    <label>
        choose report:
        <select name="reportType">
            <c:forEach items="${reports}" var="report">
                <option value="${report}">${report.name}</option>
            </c:forEach>
        </select>
    </label></br>

    <input type="submit" value="go">

</form>


<%@include file="../default/footer.jsp" %>