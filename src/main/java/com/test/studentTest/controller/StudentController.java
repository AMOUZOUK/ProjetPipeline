package com.test.studentTest.controller;

import com.test.studentTest.model.Student;
import com.test.studentTest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/v1/test")
@RestController
public class StudentController {

    private final StudentService studentService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student){
        studentService.save(student);
    }
    @GetMapping("/student")
    public ResponseEntity<List<Student>>  getAllStudents(){
        return ResponseEntity.ok(studentService.findAllStudent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student>  getStudentById( @PathVariable Integer id){
        return ResponseEntity.ok(studentService.findStudentById(id));
    }


}
