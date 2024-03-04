package validators.request_validators.teachers;

import requests.teachers.AddTeacherRequest;
import validators.primitive.IdValidator;
import validators.primitive.StringValidator;
import validators.request_validators.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorAddTeacherRequest implements IRequestValidator<AddTeacherRequest> {
    public List<String> validate(AddTeacherRequest req) {
        List<String> error_list = new ArrayList<String>();

        StringValidator s_v=new StringValidator();

        s_v.validateIsNotNull(req.getFirstName(), error_list, "FirstName");
        s_v.validateIsNotEmpty(req.getFirstName(), error_list,"FirstName");
        s_v.validateIsNotMoreThanMaxlength(req.getFirstName(), error_list, "FirstName",100);

        s_v.validateIsNotNull(req.getLastName(), error_list, "LastName");
        s_v.validateIsNotEmpty(req.getLastName(), error_list,"LastName");
        s_v.validateIsNotMoreThanMaxlength(req.getLastName(), error_list, "LastName",100);

        return error_list;
    }
}
