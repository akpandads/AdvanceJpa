package com.akpanda.advjpa.entity.singletablestrategty;

import com.akpanda.advjpa.entity.singletablestrategty.EmployeeSIngleTableStrategt;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployeeSIngleTable extends EmployeeSIngleTableStrategt {
    private Integer salary;

    public FullTimeEmployeeSIngleTable(String name, Integer hourlyWage) {
        super(name);
        this.salary = hourlyWage;
    }

    public FullTimeEmployeeSIngleTable() {
    }

    public Integer getHourlyWage() {
        return salary;
    }

    public void setHourlyWage(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "salary=" + salary +
                '}';
    }
}
