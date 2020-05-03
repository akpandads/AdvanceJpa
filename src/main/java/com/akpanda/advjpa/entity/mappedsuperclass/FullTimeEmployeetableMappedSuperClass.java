package com.akpanda.advjpa.entity.mappedsuperclass;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployeetableMappedSuperClass extends EmployeeTableMappedSuperClass {
    private Integer salary;

    public FullTimeEmployeetableMappedSuperClass(String name, Integer hourlyWage) {
        super(name);
        this.salary = hourlyWage;
    }

    public FullTimeEmployeetableMappedSuperClass() {
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
