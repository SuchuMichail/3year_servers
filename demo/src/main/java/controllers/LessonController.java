package controllers;

import exceptions.service_exceptions.NotFoundService;
import exceptions.service_exceptions.ServiceException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import requests.lessons.*;
import services.interfaces.ILessonService;

@RestController
public class LessonController {
    @Autowired
    private final ILessonService lessonService;

    public LessonController(ILessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping(value = "/addLesson")
    public ResponseEntity<?> addLesson(@Valid @RequestBody AddLessonRequest request) throws ServiceException {
        return new ResponseEntity<>(lessonService.add(request), HttpStatus.OK);
    }

    @DeleteMapping("/deleteLessonById")
    public ResponseEntity<?> deleteLessonById(@Valid @RequestBody DeleteLessonRequest request) throws NotFoundService {
        lessonService.delete(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/editLesson")
    public ResponseEntity<?> editLesson(@Valid @RequestBody EditLessonRequest request) throws ServiceException {
        lessonService.edit(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getLessonById")
    public ResponseEntity<?> getLessonById(@Valid @RequestBody GetLessonByIdRequest request) throws NotFoundService {
        return new ResponseEntity<>(lessonService.getById(request), HttpStatus.OK);
    }

    @GetMapping("/getLessonsByGroup")
    public ResponseEntity<?> getLessonByGroup(@Valid @RequestBody GetLessonsByGroupRequest request) throws ServiceException {
        return new ResponseEntity<>(lessonService.getByGroup(request), HttpStatus.OK);
    }

    @GetMapping("/getLessonsByTeacher")
    public ResponseEntity<?> getLessonByTeacher(@Valid @RequestBody GetLessonsByTeacherRequest request) throws ServiceException {
        return new ResponseEntity<>(lessonService.getByTeacher(request), HttpStatus.OK);
    }
}
