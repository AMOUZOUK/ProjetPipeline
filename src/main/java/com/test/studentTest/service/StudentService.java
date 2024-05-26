package com.test.studentTest.service;

import com.test.studentTest.model.Student;
import com.test.studentTest.repository.StudentRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRep studentRep;
    public Student findStudentById( Integer id){
        Student optionalStudent = studentRep.findById( id )
                .orElse( Student.builder()
                        .firstname("NOT_FOUND").build());
       /* if( optionalStudent.isPresent()){
            return optionalStudent.get();
        }*/
        return optionalStudent;
    }

    public List<Student> findAllStudent(){
        return (List<Student>) studentRep.findAll();
    }

    public void save( Student student ){
        studentRep.save(student);
    }
}
