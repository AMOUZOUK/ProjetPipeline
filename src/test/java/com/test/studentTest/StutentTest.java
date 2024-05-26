package com.test.studentTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.studentTest.controller.StudentController;
import com.test.studentTest.model.Student;
import com.test.studentTest.repository.StudentRep;
import com.test.studentTest.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;


@ExtendWith(MockitoExtension.class)
public class StutentTest {

    @Autowired
    private MockMvc mockMvc;

    StudentService studentService;

    @Mock
    StudentRep studentRep;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void doSet(){
        studentService = new StudentService(studentRep);
    }


    public void test_saveStudent(){
        Student stu = Student.builder().firstname("Komlavi").build();
        //c est pour les methodes void
        doThrow( new RuntimeException("Student is not save ") ).when( studentRep ).save(any(Student.class));
        studentService.save(stu);
    }

    @Test
    public void test_findAllStudent(){
        var st1 = Student.builder().firstname("Jesus").email("jesus@gmail.com").lastname("Eternel").build();
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(Student.builder().firstname("Komlavi").email("komlavi@gmail.com").lastname("Amouzou").build());
        Mockito.when(studentRep.findAll()).thenReturn(students);
        List<Student>  res = studentService.findAllStudent();

        Assertions.assertEquals(res.size(), 2);
    }

    @Test
    public void test_findStudentById(){
        Student st1 = Student.builder().firstname("Jesus").email("jesus@gmail.com").lastname("Eternel").build();
        Mockito.when(studentRep.findById(any(Integer.class))).thenReturn(Optional.of(st1));

        Student res = studentService.findStudentById( 1 );
        Assertions.assertEquals(res.getId(), st1.getId());
    }


}
