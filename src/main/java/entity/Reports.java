package entity;

public enum Reports {

    employeesWorkingHours("employees Working Hours Report"),
    profitsReport("Profits Report");

    private final String name;

    private Reports(String s) {
        name = s;
    }


    public String getName() {
        return this.name;
    }
}
