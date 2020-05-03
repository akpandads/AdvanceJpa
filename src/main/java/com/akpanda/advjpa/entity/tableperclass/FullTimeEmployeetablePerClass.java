package com.akpanda.advjpa.entity.tableperclass;

import com.akpanda.advjpa.entity.singletablestrategty.EmployeeSIngleTableStrategt;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployeetablePerClass extends EmployeeTablePerClass {
    private Integer salary;

    public FullTimeEmployeetablePerClass(String name, Integer hourlyWage) {
        super(name);
        this.salary = hourlyWage;
    }

    public FullTimeEmployeetablePerClass() {
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
