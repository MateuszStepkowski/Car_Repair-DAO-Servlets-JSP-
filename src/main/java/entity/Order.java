package entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Order {

    private Integer id;
    private Date receiveDate;
    private Date plannedStartDate;
    private Date startDate;
    private Date endDate;
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

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
