package com.akpanda.advjpa;

import com.akpanda.advjpa.entity.*;
import com.akpanda.advjpa.entity.joined.tableperclass.FullTimeEmployeetableJoined;
import com.akpanda.advjpa.entity.joined.tableperclass.PartTimeEmployeeTableJoined;
import com.akpanda.advjpa.entity.mappedsuperclass.FullTimeEmployeetableMappedSuperClass;
import com.akpanda.advjpa.entity.mappedsuperclass.PartTimeEmployeeTableMappedSuperClass;
import com.akpanda.advjpa.entity.singletablestrategty.FullTimeEmployeeSIngleTable;
import com.akpanda.advjpa.entity.singletablestrategty.PartTimeEmployeeSIngleTable;
import com.akpanda.advjpa.entity.tableperclass.FullTimeEmployeetablePerClass;
import com.akpanda.advjpa.entity.tableperclass.PartTimeEmployeeTablePerClass;
import com.akpanda.advjpa.repository.CourseReporsitory;
import com.akpanda.advjpa.repository.EmployeeRepository;
import com.akpanda.advjpa.repository.StudentReporsitory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AdvjpaApplication implements CommandLineRunner {

    @Autowired
    private CourseReporsitory courseReporsitory;

    @Autowired
    private StudentReporsitory studentReporsitory;

    @Autowired
    private EmployeeRepository employeeRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(AdvjpaApplication.class, args);
    }


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Course course = courseReporsitory.findById(10001);
        //courseReporsitory.deleteById(10001);
        courseReporsitory.save(new Course("docker"));
        courseReporsitory.playWithEntityManager();

        studentReporsitory.saveStudentWothPassport();

        List<Review> reviewList = new ArrayList<>();
        Review review = new Review("4","good try");
        Review review2 = new Review("3","beginner");
        reviewList.add(review);
        reviewList.add(review2);
        courseReporsitory.addReviewsForCourse(10003L,reviewList);
        Course course2 = courseReporsitory.findById(10002);
        Student student = new Student("Jack Ma");
        studentReporsitory.enterStudentAndCourse(student,course2);


        // Inheritance stratgeties
        FullTimeEmployeeSIngleTable fullTimeEmployee1 = new FullTimeEmployeeSIngleTable("Elon musk",1000);
        PartTimeEmployeeSIngleTable partTimeEmployee1= new PartTimeEmployeeSIngleTable("jackie chan",50);
        employeeRepository.insertEmployeeSingleTable(fullTimeEmployee1);
        employeeRepository.insertEmployeeSingleTable(partTimeEmployee1);
        logger.info("Employees ->"+employeeRepository.getAllEmployeesSingleTable());


        FullTimeEmployeetablePerClass fullTimeEmployee2 = new FullTimeEmployeetablePerClass("Elon musk",1000);
        PartTimeEmployeeTablePerClass partTimeEmployee2= new PartTimeEmployeeTablePerClass("jackie chan",50);
        employeeRepository.insertEmployeeTablePerClass(fullTimeEmployee2);
        employeeRepository.insertEmployeeTablePerClass(partTimeEmployee2);
        logger.info("Employees ->"+employeeRepository.getAllEmployeesTablePerClass());

        FullTimeEmployeetableJoined fullTimeEmployee3 = new FullTimeEmployeetableJoined("Elon musk",1000);
        PartTimeEmployeeTableJoined partTimeEmployee3= new PartTimeEmployeeTableJoined("jackie chan",50);
        employeeRepository.insertEmployeeTableJoined(fullTimeEmployee3);
        employeeRepository.insertEmployeeTableJoined(partTimeEmployee3);
        logger.info("Employees ->"+employeeRepository.getAllEmployeesJoined());

        FullTimeEmployeetableMappedSuperClass fullTimeEmployee4 = new FullTimeEmployeetableMappedSuperClass("Elon musk",1000);
        PartTimeEmployeeTableMappedSuperClass partTimeEmployee5= new PartTimeEmployeeTableMappedSuperClass("jackie chan",50);
        employeeRepository.insertFullTimeEmployeeMappedSuperClass(fullTimeEmployee4);
        employeeRepository.insertPartTimeEmployeeMappedSuperClass(partTimeEmployee5);
        logger.info("Employees ->"+employeeRepository.getFTEmployee());
        logger.info("Employees ->"+employeeRepository.getPTEmployee());
    }
}
