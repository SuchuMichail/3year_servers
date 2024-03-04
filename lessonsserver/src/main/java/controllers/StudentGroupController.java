package controllers;

import requests.student_groups.*;
import responses.IntermediateResp;
import responses.ResponseEntity;
import responses.student_groups.AddStudentGroupResponse;
import responses.student_groups.GetStudentGroupByIdResponse;
import services.IStudentGroupService;
import services.exceptions.student_groups.*;
import validators.request_validators.student_groups.*;

import java.util.List;

public class StudentGroupController {
    private IStudentGroupService service;

    private ValidatorAddStudentGroupRequest validatorAddStudentGroup;
    private ValidatorDeleteStudentGroupRequest validatorDeleteStudentGroup;
    private ValidatorEditStudentGroupRequest validatorEditStudentGroup;
    private ValidatorGetStudentGroupByIdRequest validatorGetStudentGroupById;
    private ValidatorGetStudentGroupsRequest validatorGetStudentGroups;

    public StudentGroupController(IStudentGroupService service,
                                  ValidatorAddStudentGroupRequest validatorAddStudentGroup,
                                  ValidatorDeleteStudentGroupRequest validatorDeleteStudentGroup,
                                  ValidatorEditStudentGroupRequest validatorEditStudentGroup,
                                  ValidatorGetStudentGroupByIdRequest validatorGetStudentGroupById,
                                  ValidatorGetStudentGroupsRequest validatorGetStudentGroups) {
        this.service = service;
        this.validatorAddStudentGroup = validatorAddStudentGroup;
        this.validatorDeleteStudentGroup = validatorDeleteStudentGroup;
        this.validatorEditStudentGroup = validatorEditStudentGroup;
        this.validatorGetStudentGroupById = validatorGetStudentGroupById;
        this.validatorGetStudentGroups = validatorGetStudentGroups;
    }

    public ResponseEntity<IntermediateResp<AddStudentGroupResponse>> addStudentGroup(AddStudentGroupRequest request){
        try{
            List<String> error_list_validation = validatorAddStudentGroup.validate(request);

            if(error_list_validation.isEmpty()){
                AddStudentGroupResponse response = service.addStudentGroup(request);

                return new ResponseEntity<>(new IntermediateResp<AddStudentGroupResponse>(
                        response,null ,null),
                        200);
            }else{
                return new ResponseEntity<>(new IntermediateResp<AddStudentGroupResponse>(
                        null,error_list_validation,null),
                        422);
            }
        }catch(AddStudentGroupServiceException exception) {
            return new ResponseEntity<>(new IntermediateResp<AddStudentGroupResponse>(
                    null,null,exception),
                    404);
        }catch(Exception e){
            return new ResponseEntity<>(new IntermediateResp<AddStudentGroupResponse>(
                    null,null,e),
                    500);
        }
    }
    public ResponseEntity<IntermediateResp> deleteStudentGroup(DeleteStudentGroupRequest request){
        try{
            List<String> error_list_validation = validatorDeleteStudentGroup.validate(request);

            if(error_list_validation.isEmpty()){
                service.deleteStudentGroup(request);

                return new ResponseEntity<>(new IntermediateResp(
                        null,null ,null),
                        200);
            }else{
                return new ResponseEntity<>(new IntermediateResp(
                        null,error_list_validation,null),
                        422);
            }
        }catch(DeleteStudentGroupServiceException exception) {
            return new ResponseEntity<>(new IntermediateResp(null,null,exception),404);
        }catch(Exception e){
            return new ResponseEntity<>(new IntermediateResp(null,null,e),500);
        }
    }
    public ResponseEntity<IntermediateResp> editStudentGroup(EditStudentGroupRequest request){
        try{
            List<String> error_list_validation = validatorEditStudentGroup.validate(request);

            if(error_list_validation.isEmpty()){
                service.editStudentGroup(request);

                return new ResponseEntity<>(new IntermediateResp(
                        null,null ,null),
                        200);
            }else{
                return new ResponseEntity<>(new IntermediateResp(
                        null,error_list_validation,null),
                        422);
            }
        }catch(EditStudentGroupServiceException exception) {
            return new ResponseEntity<>(new IntermediateResp(null,null,exception),404);
        }catch(Exception e){
            return new ResponseEntity<>(new IntermediateResp(null,null,e),500);
        }
    }
    public ResponseEntity<IntermediateResp<GetStudentGroupByIdResponse>> getStudentGroupById(GetStudentGroupByIdRequest request){
        try{
            List<String> error_list_validation = validatorGetStudentGroupById.validate(request);

            if(error_list_validation.isEmpty()){
                GetStudentGroupByIdResponse response = service.getStudentGroupById(request);

                return new ResponseEntity<>(new IntermediateResp<GetStudentGroupByIdResponse>(
                        response,null ,null),
                        200);
            }else{
                return new ResponseEntity<>(new IntermediateResp<GetStudentGroupByIdResponse>(
                        null,error_list_validation,null),
                        422);
            }
        }catch(GetStudentGroupByIdServiceException exception) {
            return new ResponseEntity<>(new IntermediateResp<GetStudentGroupByIdResponse>(
                    null,null,exception),
                    404);
        }catch(Exception e){
            return new ResponseEntity<>(new IntermediateResp<GetStudentGroupByIdResponse>(
                    null,null,e),
                    500);
        }
    }
    public ResponseEntity<IntermediateResp> getStudentGroups(GetStudentGroupsRequest request){
        try{
            List<String> error_list_validation = validatorGetStudentGroups.validate(request);

            if(error_list_validation.isEmpty()){
                service.getStudentGroups(request);

                return new ResponseEntity<>(new IntermediateResp(
                        null,null ,null),
                        200);
            }else{
                return new ResponseEntity<>(new IntermediateResp(
                        null,error_list_validation,null),
                        422);
            }
        }catch(GetStudentGroupsServiceException exception) {
            return new ResponseEntity<>(new IntermediateResp(null,null,exception),404);
        }catch(Exception e){
            return new ResponseEntity<>(new IntermediateResp(null,null,e),500);
        }
    }
}
