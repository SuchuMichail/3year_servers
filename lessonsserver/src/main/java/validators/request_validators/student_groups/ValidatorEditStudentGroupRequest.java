package validators.request_validators.student_groups;

import requests.student_groups.EditStudentGroupRequest;
import validators.request_validators.IRequestValidator;
import validators.primitive.IdValidator;
import validators.primitive.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorEditStudentGroupRequest implements IRequestValidator<EditStudentGroupRequest> {
    public List<String> validate(EditStudentGroupRequest req) {
        List<String> error_list = new ArrayList<String>();

        IdValidator i_v=new IdValidator();
        StringValidator s_v=new StringValidator();

        s_v.validateIsNotNull(req.getName(), error_list,"Name");
        s_v.validateIsNotEmpty(req.getName(), error_list,"Name");
        s_v.validateIsNotMoreThanMaxlength(req.getName(), error_list,"Name",100);

        i_v.validateId(req.getId(),error_list,"Id");

        return error_list;
    }
}
