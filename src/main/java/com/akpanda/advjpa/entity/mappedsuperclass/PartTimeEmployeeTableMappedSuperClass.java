package com.akpanda.advjpa.entity.mappedsuperclass;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployeeTableMappedSuperClass extends EmployeeTableMappedSuperClass {
    private Integer hourlyWage;

    public PartTimeEmployeeTableMappedSuperClass(String name, Integer hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }

    public PartTimeEmployeeTableMappedSuperClass() {
    }

    public Integer getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(Integer hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
}
