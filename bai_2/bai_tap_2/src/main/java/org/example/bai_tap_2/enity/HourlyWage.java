package org.example.bai_tap_2.enity;

public class HourlyWage {
    private Double salary;
    private String description;

    public HourlyWage() {
    }

    public HourlyWage(Double salary, String description) {
        this.salary = salary;
        this.description = description;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
