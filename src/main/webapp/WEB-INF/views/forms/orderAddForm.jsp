<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="/order/add" method="POST">
    <label>
        Receive date:
        <input type="date" name="receiveDate" required>
    </label></br>
    <label>Planned start date:
        <input type="date" name="plannedStartDate" required>
    </label></br>
    <label>
        Start date:
        <input type="date" name="startDate">
    </label></br>
    <label>End date:
        <input type="date" name="endDate">
    </label></br>
    <label>
        Employee:
        <select name="employee">
            <option>"=="</option>
            <c:forEach items="${employees}" var="employee">
                <option value="${employee.id}">${employee.surname} ${employee.forename}</option>
            </c:forEach>
        </select>
    </label></br>
    <label>
        Problem description:
        <input type="text" name="problemDescription">
    </label></br>
    <label>
        Repair description:
        <input type="text" name="repairDescription">
    </label></br>
    <label>
        Status:
        <select name="status">
            <c:forEach items="${statuses}" var="status">
                <option value="${status}">${status}</option>
            </c:forEach>
        </select>
    </label></br>
    <label>
        Vehicle:
        <select name="vehicle">
            <c:forEach items="${vehicles}" var="vehicle">
                <option value="${vehicle.id}">${vehicle.brand} ${vehicle.model} | ${vehicle.registrationNumber}</option>
            </c:forEach>
        </select>
    </label></br>
    <label>
        Client Costs:
        <input type="text" name="clientCosts">
    </label></br>
    <label>
        Parts price:
        <input type="text" name="partsCost">
    </label></br>
    <label>
        service hours amount:
        <input type="text" name="hoursAmount">
    </label></br>

    <input type="submit" value="add new Order">
</form>