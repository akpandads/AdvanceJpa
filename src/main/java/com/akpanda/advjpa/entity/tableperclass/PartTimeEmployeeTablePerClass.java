package com.akpanda.advjpa.entity.tableperclass;

import com.akpanda.advjpa.entity.singletablestrategty.EmployeeSIngleTableStrategt;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployeeTablePerClass extends EmployeeTablePerClass {
    private Integer hourlyWage;

    public PartTimeEmployeeTablePerClass(String name, Integer hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }

    public PartTimeEmployeeTablePerClass() {
    }

    public Integer getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(Integer hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}
