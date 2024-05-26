package com.test.studentTest.repository;

import com.test.studentTest.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRep extends JpaRepository<School, Integer> {
}
