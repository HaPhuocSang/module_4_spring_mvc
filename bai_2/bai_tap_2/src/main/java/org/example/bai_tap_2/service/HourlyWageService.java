package org.example.bai_tap_2.service;

import org.example.bai_tap_2.enity.HourlyWage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class HourlyWageService implements IHourlyWageService {
    private final static Map<Integer, HourlyWage> hourlyWages = new HashMap<>();
    static {
        hourlyWages.put(1,new HourlyWage(25000.0, "25.000 VNĐ / giờ"));
        hourlyWages.put(2,new HourlyWage(30000.0, "30.000 VNĐ / giờ"));
        hourlyWages.put(3,new HourlyWage(35000.0, "35.000 VNĐ / giờ"));
        hourlyWages.put(4,new HourlyWage(40000.0, "40.000 VNĐ / giờ"));
        hourlyWages.put(5,new HourlyWage(50000.0, "50.000 VNĐ / giờ"));
    }

    @Override
    public List<HourlyWage> getHourlyWages() {
        return new ArrayList<>(hourlyWages.values());
    }

    @Override
    public Double totalHourlyWages(Double morningHours, Double afternoonHours, Double eveningHours) {
        return morningHours + afternoonHours + eveningHours;
    }

    @Override
    public Double totalSalary(Double totalHours, Double hourlySalary) {
        return totalHours * hourlySalary;
    }

    @Override
    public Double checkNumber(Double number) {
        return number == null ? 0.0 :  number;
    }
}
