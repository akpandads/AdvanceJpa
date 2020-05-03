package com.akpanda.advjpa.repository;

import com.akpanda.advjpa.entity.joined.tableperclass.EmployeeTableJoined;
import com.akpanda.advjpa.entity.joined.tableperclass.FullTimeEmployeetableJoined;
import com.akpanda.advjpa.entity.mappedsuperclass.FullTimeEmployeetableMappedSuperClass;
import com.akpanda.advjpa.entity.mappedsuperclass.PartTimeEmployeeTableMappedSuperClass;
import com.akpanda.advjpa.entity.singletablestrategty.EmployeeSIngleTableStrategt;
import com.akpanda.advjpa.entity.tableperclass.EmployeeTablePerClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    @Autowired
    EntityManager entityManager;

    public void insertEmployeeSingleTable(EmployeeSIngleTableStrategt employeeSIngleTableStrategt){
        entityManager.persist(employeeSIngleTableStrategt);
    }

    public List<EmployeeSIngleTableStrategt> getAllEmployeesSingleTable(){
        return entityManager.createQuery("select e from EmployeeSIngleTableStrategt e", EmployeeSIngleTableStrategt.class).getResultList();
    }

    public void insertEmployeeTablePerClass(EmployeeTablePerClass employeeTablePerClass){
        entityManager.persist(employeeTablePerClass);
    }

    public List<EmployeeTablePerClass> getAllEmployeesTablePerClass(){
        return entityManager.createQuery("select e from EmployeeTablePerClass e", EmployeeTablePerClass.class).getResultList();
    }

    public void insertEmployeeTableJoined(EmployeeTableJoined employee) {
        entityManager.persist(employee);
    }

    public List<EmployeeTableJoined> getAllEmployeesJoined() {
        return entityManager.createQuery("select e from EmployeeTableJoined e", EmployeeTableJoined.class).getResultList();
    }

    public void insertFullTimeEmployeeMappedSuperClass(FullTimeEmployeetableMappedSuperClass fullTimeEmployee4) {
        entityManager.persist(fullTimeEmployee4);
    }

    public void insertPartTimeEmployeeMappedSuperClass(PartTimeEmployeeTableMappedSuperClass partTimeEmployee4) {
        entityManager.persist(partTimeEmployee4);
    }

    public List<FullTimeEmployeetableMappedSuperClass> getFTEmployee() {
        return entityManager.createQuery("select e from FullTimeEmployeetableMappedSuperClass e", FullTimeEmployeetableMappedSuperClass.class).getResultList();
    }

    public List<PartTimeEmployeeTableMappedSuperClass> getPTEmployee() {
        return entityManager.createQuery("select e from PartTimeEmployeeTableMappedSuperClass e", PartTimeEmployeeTableMappedSuperClass.class).getResultList();
    }
}
