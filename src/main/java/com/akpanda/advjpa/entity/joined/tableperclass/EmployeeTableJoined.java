package com.akpanda.advjpa.entity.joined.tableperclass;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class EmployeeTableJoined {
    private String name;

    @Id
    @GeneratedValue
    private Long id;

    public EmployeeTableJoined(String name) {
        this.name = name;
    }

    public EmployeeTableJoined() {
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
