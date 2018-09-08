package entity;

public class ProfitsReport {

    private double clientCosts;
    private double partsCost;
    private double serviceCost;
    private double hoursAmount;
    private double avgCostPerHour;
    private double profit;


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

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public double getHoursAmount() {
        return hoursAmount;
    }

    public void setHoursAmount(double hoursAmount) {
        this.hoursAmount = hoursAmount;
    }

    public double getProfit() {
        return profit;
    }


    public void setProfit() {
        this.profit = clientCosts - partsCost - serviceCost;
    }

    public double getAvgCostPerHour() {
        return avgCostPerHour;
    }

    public void setAvgCostPerHour() {
        this.avgCostPerHour = this.serviceCost/this.hoursAmount;
    }
}
