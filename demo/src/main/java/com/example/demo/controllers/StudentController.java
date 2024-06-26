package com.example.demo.controllers;

import com.example.demo.exceptions.service_exceptions.NotFoundService;
import com.example.demo.exceptions.service_exceptions.ServiceException;
import com.example.demo.requests.students.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.interfaces.IStudentService;

@RestController
public class StudentController {
    private final IStudentService service;

    public StudentController(IStudentService service) {
        this.service = service;
    }

    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(@Valid @RequestBody AddStudentRequest request) throws NotFoundService {
        return new ResponseEntity<>(service.addStudent(request), HttpStatus.OK);
    }

    @GetMapping("/getStudentById")
    public ResponseEntity<?> getStudentById(@Valid @RequestBody GetStudentByIdRequest request) throws NotFoundService {
        return new ResponseEntity<>(service.getStudentById(request), HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudentById")
    public ResponseEntity<?> deleteStudent(@Valid @RequestBody DeleteStudentRequest request) throws NotFoundService {
        System.out.println("id = " + request.getId());
        service.delete(request);
        System.out.println("I DELETED");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/editStudent")
    public ResponseEntity<?> editStudent(@Valid @RequestBody EditStudentRequest request) throws ServiceException {
        service.editStudent(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getStudentsByGroupId")
    public ResponseEntity<?> getStudentsByGroup(@Valid @RequestBody GetStudentsByGroupRequest request) throws NotFoundService {
        return new ResponseEntity<>(service.getStudentsByGroup(request), HttpStatus.OK);
    }
}
