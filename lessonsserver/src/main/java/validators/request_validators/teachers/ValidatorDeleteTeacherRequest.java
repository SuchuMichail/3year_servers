package validators.request_validators.teachers;

import requests.teachers.DeleteTeacherRequest;
import validators.primitive.IdValidator;
import validators.request_validators.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorDeleteTeacherRequest implements IRequestValidator<DeleteTeacherRequest> {
    public List<String> validate(DeleteTeacherRequest req) {
        List<String> error_list = new ArrayList<String>();

        IdValidator i_v=new IdValidator();

        i_v.validateId(req.getId(),error_list,"Id");

        return error_list;
    }
}
