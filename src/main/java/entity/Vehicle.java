package entity;

import java.sql.Timestamp;

public class Vehicle {

    private Integer id;
    private String model;
    private String brand;
    private int productionYear;
    private String registrationNumber;
    private Timestamp nextInspection;
    private Customer customer;

    public Vehicle() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Timestamp getNextInspection() {
        return nextInspection;
    }

    public void setNextInspection(Timestamp nextInspection) {
        this.nextInspection = nextInspection;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
