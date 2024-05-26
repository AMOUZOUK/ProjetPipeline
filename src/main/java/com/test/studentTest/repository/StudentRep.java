package com.test.studentTest.repository;

import com.test.studentTest.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRep extends CrudRepository<Student, Integer> {
}
