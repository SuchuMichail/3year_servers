package validators.request_validators.student_groups;

import requests.student_groups.AddStudentGroupRequest;
import validators.request_validators.IRequestValidator;
import validators.primitive.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorAddStudentGroupRequest implements IRequestValidator<AddStudentGroupRequest> {
    public List<String> validate(AddStudentGroupRequest req) {
        List<String> error_list = new ArrayList<String>();

        StringValidator s_v=new StringValidator();

        s_v.validateIsNotNull(req.getName(), error_list,"Name");
        s_v.validateIsNotEmpty(req.getName(), error_list,"Name");
        s_v.validateIsNotMoreThanMaxlength(req.getName(), error_list,"Name",100);

        return error_list;
    }
}
