package validators.request_validators.students;

import requests.students.DeleteStudentRequest;
import validators.primitive.IdValidator;
import validators.request_validators.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorDeleteStudentRequest implements IRequestValidator<DeleteStudentRequest> {
    public ValidatorDeleteStudentRequest(){}

    public List<String> validate(DeleteStudentRequest req) {
        List<String> error_list = new ArrayList<String>();

        IdValidator i_v=new IdValidator();

        i_v.validateId(req.getId(),error_list,"Id");

        return error_list;
    }
}
