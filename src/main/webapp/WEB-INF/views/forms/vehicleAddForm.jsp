<form action="/vehicle/add" method="POST">

    <input type="hidden" name="customerID" value="${customer.id}">

    <label>
        model:
        <input type="text" name="model">
    </label></br>
    <label>
        brand:
        <input type="text" name="brand">
    </label></br>
    <label>
        production year:
        <input type="number" name="productionYear">
    </label></br>
    <label>
        registration number:
        <input type="text" name="registrationNumber">
    </label></br>
    <label>
        next inspection:
        <input type="date" name="nextInspection">
    </label></br>


    <input type="submit" value="Add vehicle">

</form>