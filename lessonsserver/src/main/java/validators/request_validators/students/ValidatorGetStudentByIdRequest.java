package validators.request_validators.students;

import requests.students.GetStudentByIdRequest;
import validators.primitive.IdValidator;
import validators.request_validators.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorGetStudentByIdRequest implements IRequestValidator<GetStudentByIdRequest> {
    public ValidatorGetStudentByIdRequest(){}

    public List<String> validate(GetStudentByIdRequest req) {
        List<String> error_list = new ArrayList<String>();

        IdValidator i_v=new IdValidator();

        i_v.validateId(req.getId(),error_list,"Id");

        return error_list;
    }
}
