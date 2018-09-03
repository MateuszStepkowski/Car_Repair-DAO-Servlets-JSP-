package entity;

import java.sql.Timestamp;

public class Order {

    private Integer id;
    private Timestamp receiveDate;
    private Timestamp plannedStartDate;
    private Timestamp startDate;
    private Timestamp endDate;
    private Employee employee;
    private String problemDescription;
    private String repairDescription;
    private Status status;
    private Vehicle vehicle;
    private double clientCosts;
    private double partsCost;
    private double serviceCostPerHour;
    private double hoursAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Timestamp receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Timestamp getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Timestamp plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
        setServiceCostPerHour();
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getClientCosts() {
        return clientCosts;
    }

    public void setClientCosts(double clientCosts) {
        this.clientCosts = clientCosts;
    }

    public double getPartsCost() {
        return partsCost;
    }

    public void setPartsCost(double partsCost) {
        this.partsCost = partsCost;
    }

    public double getServiceCostPerHour() {
        return serviceCostPerHour;
    }

    public void setServiceCostPerHour() {
        this.serviceCostPerHour = this.getEmployee().getHourSalary();
    }

    public double getHoursAmount() {
        return hoursAmount;
    }

    public void setHoursAmount(double hoursAmount) {
        this.hoursAmount = hoursAmount;
    }
}
