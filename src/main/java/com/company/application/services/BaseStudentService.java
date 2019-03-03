package com.company.application.services;

import domain.business.StudentService;
import domain.model.data.Student;
import domain.model.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class BaseStudentService implements StudentService {

    @Override
    public Student getByName(String name) {
        return null;
    }
}
