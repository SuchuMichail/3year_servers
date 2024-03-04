package validators.request_validators.subjects;

import requests.subjects.DeleteSubjectRequest;
import validators.primitive.IdValidator;
import validators.request_validators.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorDeleteSubjectRequest implements IRequestValidator<DeleteSubjectRequest> {
    public List<String> validate(DeleteSubjectRequest req) {
        List<String> error_list = new ArrayList<String>();

        IdValidator i_v=new IdValidator();

        i_v.validateId(req.getId(),error_list,"Id");

        return error_list;
    }
}
