package controllers;

import exceptions.service_exceptions.NotFoundService;
import exceptions.service_exceptions.ServiceException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import requests.subjects.AddSubjectRequest;
import requests.subjects.DeleteSubjectRequest;
import requests.subjects.EditSubjectRequest;
import requests.subjects.GetSubjectByIdRequest;
import services.interfaces.ISubjectService;

@RestController
public class SubjectController {
    @Autowired
    private final ISubjectService subjectService;

    public SubjectController(ISubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping(value = "/addSubject")
    public ResponseEntity<?> addSubject(@Valid @RequestBody AddSubjectRequest request) throws NotFoundService {
        return new ResponseEntity<>(subjectService.add(request), HttpStatus.OK);
    }

    @DeleteMapping("/deleteSubjectById")
    public ResponseEntity<?> deleteSubjectById(@Valid @RequestBody DeleteSubjectRequest request) throws NotFoundService {
        subjectService.delete(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/editSubject")
    public ResponseEntity<?> editSubject(@Valid @RequestBody EditSubjectRequest request) throws ServiceException {
        subjectService.edit(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getSubjectById")
    public ResponseEntity<?> getSubjectById(@Valid @RequestBody GetSubjectByIdRequest request) throws NotFoundService {
        return new ResponseEntity<>(subjectService.getById(request), HttpStatus.OK);
    }

    @GetMapping("/getSubjects")
    public ResponseEntity<?> getSubjects() {
        return new ResponseEntity<>(subjectService.getAllSubjects(), HttpStatus.OK);
    }
}
