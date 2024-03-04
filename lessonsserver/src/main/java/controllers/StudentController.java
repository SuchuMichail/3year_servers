package controllers;

import requests.students.*;
import responses.ResponseEntity;
import responses.students.AddStudentResponse;
import responses.students.GetStudentByIdResponse;
import services.IStudentService;
import responses.IntermediateResp;
import services.exceptions.students.*;
import validators.request_validators.IRequestValidator;
import validators.request_validators.students.*;

import java.util.List;

public class StudentController {
    private final IStudentService service;

    private IRequestValidator validator;

    public StudentController(IStudentService service) {
        this.service = service;
    }

    public ResponseEntity<IntermediateResp<AddStudentResponse>> addStudent(AddStudentRequest request){
        validator = new ValidatorAddStudentRequest();

        try{
            List<String> error_list_validation = validator.validate(request);

            if(error_list_validation.isEmpty()){
                AddStudentResponse response = service.addStudent(request);

                return new ResponseEntity<>(
                        new IntermediateResp<AddStudentResponse>( response,null ,null),
                        200);
            }
            return new ResponseEntity<>(new IntermediateResp<AddStudentResponse>(
                    null,error_list_validation,null),
                    422);

        }catch(AddStudentServiceException exception) {
            return new ResponseEntity<>(new IntermediateResp<AddStudentResponse>(
                    null,null,exception),
                    404);
        }catch(Exception e){
            return new ResponseEntity<>(new IntermediateResp<AddStudentResponse>(
                    null,null,e),
                    500);
        }
    }

    public ResponseEntity<IntermediateResp<GetStudentByIdResponse>> getStudentById(GetStudentByIdRequest request){
        validator = new ValidatorGetStudentByIdRequest();

        try{
            List<String> error_list_validation = validator.validate(request);

            if(error_list_validation.isEmpty()){
                GetStudentByIdResponse response = service.getStudentById(request);

                return new ResponseEntity<>(new IntermediateResp<GetStudentByIdResponse>(
                        response,null,null),
                        200);
            }
            return new ResponseEntity<>(new IntermediateResp<GetStudentByIdResponse>(
                    null,error_list_validation,null),
                    422);

        }catch(GetStudentByIdServiceException exception) {
            return new ResponseEntity<>(new IntermediateResp<GetStudentByIdResponse>(
                    null,null,exception),
                    404);
        }catch(Exception e){
            return new ResponseEntity<>(new IntermediateResp<GetStudentByIdResponse>(
                    null,null,e),
                    500);
        }
    }

    public ResponseEntity<IntermediateResp> deleteStudent(DeleteStudentRequest request){
        validator = new ValidatorDeleteStudentRequest();

        try{
            List<String> error_list_validation = validator.validate(request);

            if(error_list_validation.isEmpty()){
                service.deleteStudent(request);

                return new ResponseEntity<>(new IntermediateResp(
                        null,null,null),
                        200);
            }
            return new ResponseEntity<>(new IntermediateResp(
                    null,error_list_validation,null),
                    422);

        }catch(DeleteStudentServiceException exception) {
            return new ResponseEntity<>(new IntermediateResp(
                    null,null,exception),
                    404);
        }catch(Exception e){
            return new ResponseEntity<>(new IntermediateResp(null,null,e),500);
        }
    }

    public ResponseEntity<IntermediateResp> editStudent(EditStudentRequest request){
        validator = new ValidatorEditStudentRequest();

        try{
            List<String> error_list_validation = validator.validate(request);

            if(error_list_validation.isEmpty()){
                service.editStudent(request);

                return new ResponseEntity<>(new IntermediateResp(
                        null,null,null),
                        200);
            }else{
                return new ResponseEntity<>(new IntermediateResp(
                        null,error_list_validation,null),
                        422);
            }
        }catch(EditStudentServiceException exception) {
            return new ResponseEntity<>(new IntermediateResp(
                    null,null,exception),
                    404);
        }catch(Exception e){
            return new ResponseEntity<>(new IntermediateResp(
                    null,null,e),
                    500);
        }
    }

    public ResponseEntity<IntermediateResp<List<GetStudentByIdResponse>>> getStudentsByGroup(GetStudentsByGroupRequest request) {
        validator = new ValidatorGetStudentsByGroupRequest();

        try {
            List<String> error_list_validation = validator.validate(request);

            if (error_list_validation.isEmpty()) {
                List<GetStudentByIdResponse> response = service.getStudentsByGroup(request);

                return new ResponseEntity<>(new IntermediateResp<List<GetStudentByIdResponse>>(
                        response, null, null),
                        200);
            } else {
                return new ResponseEntity<>(new IntermediateResp<List<GetStudentByIdResponse>>(
                        null, error_list_validation, null),
                        422);
            }
        }catch(GetStudentsByGroupServiceException exception){
            return new ResponseEntity<>(new IntermediateResp<List<GetStudentByIdResponse>>(
                    null,null,exception),
                    404);
        }catch(Exception e){
            return new ResponseEntity<>(new IntermediateResp<List<GetStudentByIdResponse>>(
                    null,null,e),
                    500);
        }
    }
}
