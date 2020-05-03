package com.akpanda.advjpa.entity.joined.tableperclass;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployeetableJoined extends EmployeeTableJoined {
    private Integer salary;

    public FullTimeEmployeetableJoined(String name, Integer hourlyWage) {
        super(name);
        this.salary = hourlyWage;
    }

    public FullTimeEmployeetableJoined() {
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
