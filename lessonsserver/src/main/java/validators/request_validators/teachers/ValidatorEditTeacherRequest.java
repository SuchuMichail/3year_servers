package validators.request_validators.teachers;

import requests.teachers.EditTeacherRequest;
import validators.primitive.IdValidator;
import validators.primitive.StringValidator;
import validators.request_validators.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorEditTeacherRequest implements IRequestValidator<EditTeacherRequest> {
    public List<String> validate(EditTeacherRequest req) {
        List<String> error_list = new ArrayList<String>();

        IdValidator i_v=new IdValidator();
        StringValidator s_v=new StringValidator();

        s_v.validateIsNotNull(req.getFirstName(), error_list, "FirstName");
        s_v.validateIsNotEmpty(req.getFirstName(), error_list,"FirstName");
        s_v.validateIsNotMoreThanMaxlength(req.getFirstName(), error_list, "FirstName",100);

        s_v.validateIsNotNull(req.getLastName(), error_list, "LastName");
        s_v.validateIsNotEmpty(req.getLastName(), error_list,"LastName");
        s_v.validateIsNotMoreThanMaxlength(req.getLastName(), error_list, "LastName",100);

        i_v.validateId(req.getId(),error_list,"Id");

        return error_list;
    }
}
