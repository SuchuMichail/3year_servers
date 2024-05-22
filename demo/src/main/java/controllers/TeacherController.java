package controllers;

import exceptions.service_exceptions.NotFoundService;
import exceptions.service_exceptions.ServiceException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import requests.teachers.AddTeacherRequest;
import requests.teachers.DeleteTeacherRequest;
import requests.teachers.EditTeacherRequest;
import requests.teachers.GetTeacherByIdRequest;
import services.interfaces.ITeacherService;

@RestController
public class TeacherController {
    @Autowired
    private final ITeacherService teacherService;

    public TeacherController(ITeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping(value = "/addTeacher")
    public ResponseEntity<?> addTeacher(@Valid @RequestBody AddTeacherRequest request) throws NotFoundService {
        return new ResponseEntity<>(teacherService.add(request), HttpStatus.OK);
    }

    @DeleteMapping("/deleteTeacherById")
    public ResponseEntity<?> deleteTeacherById(@Valid @RequestBody DeleteTeacherRequest request) throws NotFoundService {
        teacherService.delete(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/editTeacher")
    public ResponseEntity<?> editTeacher(@Valid @RequestBody EditTeacherRequest request) throws ServiceException {
        teacherService.edit(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getTeacherById")
    public ResponseEntity<?> getTeacherById(@Valid @RequestBody GetTeacherByIdRequest request) throws NotFoundService {
        return new ResponseEntity<>(teacherService.getById(request), HttpStatus.OK);
    }

    @GetMapping("/getTeachers")
    public ResponseEntity<?> getTeachers() {
        return new ResponseEntity<>(teacherService.getAllTeachers(), HttpStatus.OK);
    }
}
