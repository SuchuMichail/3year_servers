package com.example.demo.services.realizations;

import com.example.demo.entities.*;
import com.example.demo.repositories.*;
import com.example.demo.requests.lessons.*;
import com.example.demo.exceptions.service_exceptions.NotFoundService;
import com.example.demo.exceptions.service_exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.responses.lessons.AddLessonResponse;
import com.example.demo.responses.lessons.GetLessonByIdResponse;
import com.example.demo.services.interfaces.ILessonService;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService implements ILessonService {
    @Autowired
    private ISubjectRepository subjectRepository;
    @Autowired
    private ITeacherRepository teacherRepository;
    @Autowired
    private IStudentGroupRepository studentGroupRepository;
    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private ILessonRepository lessonRepository;
    @Autowired
    private ILessonAttendanceRepository lessonAttendanceRepository;

    @Override
    public AddLessonResponse add(AddLessonRequest request) throws ServiceException {
        teacherRepository.findById(request.getTeacherId()).orElseThrow(() -> new ServiceException("invalid teacher id"));
        subjectRepository.findById(request.getSubjectId()).orElseThrow(() -> new ServiceException("invalid subject id"));
        studentGroupRepository.findById(request.getGroupId()).orElseThrow(() -> new ServiceException("invalid group id"));

        //проверим, все ли записанные в список посещаемости студенты реально существуют
        if (request.getAttendanceList() != null) {
            List<Long> attendanceList = request.getAttendanceList();
            for (Long id : attendanceList) {
                Student student = studentRepository.findById(id).orElseThrow(() -> new ServiceException("invalid student id"));
                Long groupId = student.getGroup().getId();
                if (!groupId.equals(request.getGroupId())) {
                    throw new ServiceException("student " + student.getId() + "not from group " + groupId);
                }
            }
        }

        Lesson lesson = new Lesson(
                null,
                new Subject(request.getSubjectId(), null),
                request.getStartDate(),
                request.getEndDate(),
                new Teacher(request.getTeacherId(), null, null, null),
                new StudentGroup(request.getGroupId(), null));

        Lesson lessonSave = lessonRepository.save(lesson);

        if (request.getAttendanceList() != null) {
            LessonAttendance lessonAttendance = new LessonAttendance(
                    null, lessonSave, request.getAttendanceList().isEmpty()
                    ? new ArrayList<>()
                    : request.getAttendanceList().stream()
                    .map(o -> new Student(o, null, null, null, null, null))
                    .toList()
            );
            lessonAttendanceRepository.save(lessonAttendance);
        }
        return new AddLessonResponse(lessonSave);
    }

    @Override
    public void delete(DeleteLessonRequest request) throws NotFoundService {
        lessonRepository.findById(request.getId()).orElseThrow(() -> new NotFoundService("invalid lesson id"));
        lessonAttendanceRepository.deleteAttendanceByLessonId(request.getId());
        lessonRepository.deleteById(request.getId());
    }

    @Override
    public void edit(EditLessonRequest request) throws ServiceException {
        Lesson lesson = lessonRepository.findById(request.getId()).orElseThrow(() -> new ServiceException("invalid lesson id"));
        studentGroupRepository.findById(request.getGroupId()).orElseThrow(() -> new ServiceException("invalid group id"));
        teacherRepository.findById(request.getTeacherId()).orElseThrow(() -> new ServiceException("invalid teacher id"));
        subjectRepository.findById(request.getSubjectId()).orElseThrow(() -> new ServiceException("invalid subject id"));
        if (request.getAttendanceList() != null) {
            List<Long> attendanceList = request.getAttendanceList();
            for (var id : attendanceList) {
                Student student = studentRepository.findById(id).orElseThrow(() -> new ServiceException("invalid student id"));
                Long groupId = student.getGroup().getId();
                if (!groupId.equals(request.getGroupId())) {
                    throw new ServiceException("student " + student.getId() + "not from group " + groupId);
                }
            }
        }
        lessonRepository.update(
                request.getSubjectId(),
                request.getStartDate(),
                request.getEndDate(),
                request.getTeacherId(),
                request.getGroupId(),
                request.getId()
        );
        if (lessonAttendanceRepository.findAttendanceByLessonId(request.getId()) != null) {
            lessonAttendanceRepository.deleteAttendanceByLessonId(request.getId());
        }
        if (request.getAttendanceList() != null) {
            LessonAttendance lessonAttendance = new LessonAttendance(
                null,
                lesson,
                request.getAttendanceList().isEmpty()
                ? new ArrayList<>()
                : request.getAttendanceList().stream()
                .map(o -> new Student(o, null, null, null, null, null))
                .toList()
            );
            lessonAttendanceRepository.save(lessonAttendance);
        }
    }

    @Override
    public GetLessonByIdResponse getById(GetLessonByIdRequest request) throws NotFoundService {
        return new GetLessonByIdResponse(
                lessonRepository
                        .findById(request.getId())
                        .orElseThrow(() -> new NotFoundService("invalid lesson id")),
                lessonAttendanceRepository.findAttendanceByLessonId(request.getId()));
    }

    @Override
    public List<GetLessonByIdResponse> getByGroup(GetLessonsByGroupRequest request) throws ServiceException {
        studentGroupRepository.findById(request.getGroupId()).orElseThrow(() -> new ServiceException("invalid group id"));
        return lessonRepository.findAllLessonsByGroupId(request.getGroupId(), request.getStartDate(), request.getEndDate()).stream()
                .map(o -> new GetLessonByIdResponse(o, lessonAttendanceRepository.findAttendanceByLessonId(o.getId())))
                .toList();
    }

    @Override
    public List<GetLessonByIdResponse> getByTeacher(GetLessonsByTeacherRequest request) throws ServiceException {
        teacherRepository.findById(request.getTeacherId()).orElseThrow(() -> new ServiceException("invalid teacher id"));
        return lessonRepository.findAllLessonsByTeacherId(request.getTeacherId(), request.getStartDate(), request.getEndDate()).stream()
                .map(o -> new GetLessonByIdResponse(o, lessonAttendanceRepository.findAttendanceByLessonId(o.getId())))
                .toList();
    }
}
