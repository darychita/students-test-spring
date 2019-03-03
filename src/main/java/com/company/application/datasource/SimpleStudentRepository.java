package com.company.application.datasource;

import domain.model.data.Student;
import domain.model.repository.StudentRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleStudentRepository implements StudentRepository {

    /**
     * This method emulates saving to database
     * */
    @Override
    public Student save(Student student) {
        return student;
    }

    @Override
    public Student findByName(String name) {
        return new Student(name, 0);
    }
}
