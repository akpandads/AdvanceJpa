package com.akpanda.advjpa.entity.joined.tableperclass;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployeeTableJoined extends EmployeeTableJoined {
    private Integer hourlyWage;

    public PartTimeEmployeeTableJoined(String name, Integer hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }

    public PartTimeEmployeeTableJoined() {
    }

    public Integer getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(Integer hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}
