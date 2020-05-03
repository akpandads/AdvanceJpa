package com.akpanda.advjpa.entity.mappedsuperclass;

import javax.persistence.*;

@MappedSuperclass
public abstract class EmployeeTableMappedSuperClass {
    private String name;

    @Id
    @GeneratedValue
    private Long id;

    public EmployeeTableMappedSuperClass(String name) {
        this.name = name;
    }

    public EmployeeTableMappedSuperClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public Long getId() {
        return id;
    }

}
