package domain.business;

import domain.model.data.Student;

public interface StudentService {

    Student getByName(String name);
}
