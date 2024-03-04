package validators.request_validators.lessons;

import requests.lessons.GetLessonByIdRequest;
import validators.request_validators.IRequestValidator;
import validators.primitive.IdValidator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorGetLessonByIdRequest implements IRequestValidator<GetLessonByIdRequest> {
    public List<String> validate(GetLessonByIdRequest req) {
        List<String> error_list = new ArrayList<String>();

        IdValidator i_v=new IdValidator();

        i_v.validateId(req.getId(),error_list,"Id");

        return error_list;
    }
}
