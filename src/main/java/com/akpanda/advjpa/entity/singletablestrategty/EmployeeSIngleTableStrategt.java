package com.akpanda.advjpa.entity.singletablestrategty;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Employee_Type")
public abstract class EmployeeSIngleTableStrategt {
    private String name;

    @Id
    @GeneratedValue
    private Long id;

    public EmployeeSIngleTableStrategt(String name) {
        this.name = name;
    }

    public EmployeeSIngleTableStrategt() {
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
