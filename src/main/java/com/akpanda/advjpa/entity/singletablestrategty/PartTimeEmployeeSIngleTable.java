package com.akpanda.advjpa.entity.singletablestrategty;

import com.akpanda.advjpa.entity.singletablestrategty.EmployeeSIngleTableStrategt;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployeeSIngleTable extends EmployeeSIngleTableStrategt {
    private Integer hourlyWage;

    public PartTimeEmployeeSIngleTable(String name, Integer hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }

    public PartTimeEmployeeSIngleTable() {
    }

    public Integer getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(Integer hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}
