package com.example.demo.controllers;

import com.example.demo.exceptions.service_exceptions.NotFoundService;
import com.example.demo.exceptions.service_exceptions.ServiceException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.requests.student_groups.AddStudentGroupRequest;
import com.example.demo.requests.student_groups.DeleteStudentGroupRequest;
import com.example.demo.requests.student_groups.EditStudentGroupRequest;
import com.example.demo.requests.student_groups.GetStudentGroupByIdRequest;
import com.example.demo.services.interfaces.IStudentGroupService;

@RestController
public class StudentGroupController {
    @Autowired
    private final IStudentGroupService studentGroupService;

    public StudentGroupController(IStudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    @PostMapping(value = "/addStudentGroup")
    public ResponseEntity<?> addStudentGroup(@Valid @RequestBody AddStudentGroupRequest request) throws NotFoundService {
        return new ResponseEntity<>(studentGroupService.addStudentGroup(request), HttpStatus.OK);
    }

    @GetMapping("/a")
    public void aaa() {
        System.out.println("help");
    }

    @DeleteMapping("/deleteStudentGroupById")
    public ResponseEntity<?> deleteStudentGroup(@Valid @RequestBody DeleteStudentGroupRequest request) throws ServiceException {
        studentGroupService.deleteStudentGroup(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/editStudentGroup")
    public ResponseEntity<?> editStudentGroup(@Valid @RequestBody EditStudentGroupRequest request) throws NotFoundService {
        studentGroupService.editStudentGroup(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getStudentGroupById")
    public ResponseEntity<?> getStudentGroupById(@Valid @RequestBody GetStudentGroupByIdRequest request) throws NotFoundService {
        return new ResponseEntity<>(studentGroupService.getStudentGroupById(request), HttpStatus.OK);
    }
}
