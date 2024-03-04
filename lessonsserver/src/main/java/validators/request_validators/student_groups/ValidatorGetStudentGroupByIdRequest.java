package validators.request_validators.student_groups;

import requests.student_groups.GetStudentGroupByIdRequest;
import validators.request_validators.IRequestValidator;
import validators.primitive.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorGetStudentGroupByIdRequest implements IRequestValidator<GetStudentGroupByIdRequest> {
    public List<String> validate(GetStudentGroupByIdRequest req) {
        List<String> error_list = new ArrayList<String>();

        IdValidator i_v=new IdValidator();

        i_v.validateId(req.getId(),error_list,"Id");

        return error_list;
    }
}
