package controllers;

import exceptions.service_exceptions.NotFoundService;
import exceptions.service_exceptions.ServiceException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import requests.student_groups.AddStudentGroupRequest;
import requests.student_groups.DeleteStudentGroupRequest;
import requests.student_groups.EditStudentGroupRequest;
import requests.student_groups.GetStudentGroupByIdRequest;
import services.interfaces.IStudentGroupService;

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
