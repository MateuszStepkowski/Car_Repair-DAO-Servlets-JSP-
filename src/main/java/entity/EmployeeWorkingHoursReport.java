package entity;

public class EmployeeWorkingHoursReport {

    private int employeeID;
    private String employeeFullName;
    private double hoursAmount;

    public EmployeeWorkingHoursReport(Employee employee) {
        this.employeeID = employee.getId();
        this.employeeFullName = employee.getForename()+" "+employee.getSurname();
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public double getHoursAmount() {
        return hoursAmount;
    }

    public void setHoursAmount(double hoursAmount) {
        this.hoursAmount = hoursAmount;
    }
}
