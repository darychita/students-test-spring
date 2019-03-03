package domain.model.repository;

import domain.model.data.Student;

public interface StudentRepository {

    Student save(Student student);
    Student findByName(String name);
}
