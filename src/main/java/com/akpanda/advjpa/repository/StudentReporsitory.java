package com.akpanda.advjpa.repository;

import com.akpanda.advjpa.entity.Course;
import com.akpanda.advjpa.entity.Passport;
import com.akpanda.advjpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentReporsitory {

    @Autowired
    EntityManager entityManager;

    public Student findById(long id){
        return entityManager.find(Student.class,id);
    }

    public void save(Student student){
        if(student.getId()==null){
            entityManager.persist(student);
        }
        else{
            entityManager.merge(student);
        }

    }

    public void deleteById(long id){
        Student student = findById(id);
        entityManager.remove(student);
    }

    public void saveStudentWothPassport(){
        Passport passport = new Passport("G176251276");
        entityManager.persist(passport);
        Student student = new Student("Mike");
        student.setPassport(passport);
        entityManager.persist(student);
    }

    public void playWithEntityManager(){
        Student student1 = new Student("aws funda");
        entityManager.persist(student1);
        entityManager.flush();

        student1.setName("new aws funda");
        entityManager.flush();

        Student student2 = new Student("angularjs");
        entityManager.persist(student2);
        entityManager.flush();

        //entityManager.detach(student2);
        student2.setName("angular 8");

        entityManager.refresh(student2); // gets the data from db and synchs it up
        entityManager.flush();

        entityManager.clear(); // clears all managed entities

        student1.setName("azure to aws migration");
    }

    public void enterStudentAndCourse(Student student,Course course){
        entityManager.persist(student);
        entityManager.persist(course);
        course.getStudents().add(student);
        student.getCourseList().add(course);

    }
}
