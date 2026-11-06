package org.example.bai_tap_2.service;

import org.example.bai_tap_2.enity.HourlyWage;

import java.util.List;

public interface IHourlyWageService {
    List<HourlyWage> getHourlyWages();
    Double totalHourlyWages(Double morningHours,  Double afternoonHours, Double eveningHours);
    Double totalSalary(Double totalHours, Double hourlySalary);
    Double checkNumber(Double number);
}
