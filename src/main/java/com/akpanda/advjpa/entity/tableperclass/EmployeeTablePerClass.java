package com.akpanda.advjpa.entity.tableperclass;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class EmployeeTablePerClass {
    private String name;

    @Id
    @GeneratedValue
    private Long id;

    public EmployeeTablePerClass(String name) {
        this.name = name;
    }

    public EmployeeTablePerClass() {
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
