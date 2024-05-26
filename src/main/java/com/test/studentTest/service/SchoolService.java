package com.test.studentTest.service;

import com.test.studentTest.model.School;
import com.test.studentTest.repository.SchoolRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SchoolService {

    private final SchoolRep schoolRep;

    public List<School> getAllSchool(){
        return schoolRep.findAll();
    }


}
