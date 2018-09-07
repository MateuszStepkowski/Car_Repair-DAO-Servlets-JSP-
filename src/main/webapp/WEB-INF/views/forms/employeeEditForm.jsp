<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../default/header.jsp" %>

<h2>Edit employee | id: ${employee.id} </h2>

<form action="/employee/edit" method="POST">

    <input type="hidden" value="${employee.id}" name="employeeID">

    <label>forename:
        <input type="text" name="forename" required value="${employee.forename}">
    </label><br>
    <label>surname:
        <input type="text" name="surname" required value="${employee.surname}">
    </label><br>
    <label>address:
        <input type="text" name="address" required
               value="${employee.address}">
    </label><br>
    <label>phone number:
        <input type="text" name="phoneNumber" required
               value="${employee.phoneNumber}">
    </label><br>
    <label>note:
        <textarea name="note" rows="4" cols="12">${employee.note}</textarea>
    </label><br>
    <label>hour salary:
        <input type="text" name="hourSalary" required
               value="${employee.hourSalary}">
    </label><br>
    <input type="submit" value="save changes"/>

</form>


<%@include file="../default/footer.jsp" %>
