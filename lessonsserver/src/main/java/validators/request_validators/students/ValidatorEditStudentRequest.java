package validators.request_validators.students;

import requests.students.EditStudentRequest;
import validators.primitive.IdValidator;
import validators.primitive.StringValidator;
import validators.request_validators.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorEditStudentRequest implements IRequestValidator<EditStudentRequest> {
    public ValidatorEditStudentRequest(){}

    public List<String> validate(EditStudentRequest req) {
        List<String> error_list = new ArrayList<String>();

        IdValidator i_v=new IdValidator();
        StringValidator s_v=new StringValidator();

        s_v.validateIsNotNull(req.getFirstName(),error_list,"FirstName");
        s_v.validateIsNotEmpty(req.getFirstName(),error_list,"FirstName");
        s_v.validateIsNotMoreThanMaxlength(req.getFirstName(),error_list,"FirstName",100);

        s_v.validateIsNotNull(req.getLastName(),error_list,"LastName");
        s_v.validateIsNotEmpty(req.getLastName(),error_list,"LastName");
        s_v.validateIsNotMoreThanMaxlength(req.getLastName(),error_list,"LastName",100);

        s_v.validateIsNotNull(req.getStatus(),error_list,"Status");
        s_v.validateIsNotEmpty(req.getStatus(),error_list,"Status");
        s_v.validateIsNotMoreThanMaxlength(req.getStatus(),error_list,"Status",100);

        i_v.validateId(req.getId(),error_list,"Id");
        i_v.validateId(req.getGroupId(),error_list,"GroupId");

        return error_list;
    }
}
