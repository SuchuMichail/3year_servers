package validators.request_validators.subjects;

import requests.subjects.GetSubjectByIdRequest;
import validators.primitive.IdValidator;
import validators.request_validators.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorGetSubjectByIdRequest implements IRequestValidator<GetSubjectByIdRequest> {
    public List<String> validate(GetSubjectByIdRequest req) {
        List<String> error_list = new ArrayList<String>();

        IdValidator i_v=new IdValidator();

        i_v.validateId(req.getId(),error_list,"Id");

        return error_list;
    }
}
