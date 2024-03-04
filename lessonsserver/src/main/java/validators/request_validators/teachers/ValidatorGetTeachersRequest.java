package validators.request_validators.teachers;

import requests.teachers.GetTeachersRequest;
import validators.request_validators.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorGetTeachersRequest implements IRequestValidator<GetTeachersRequest> {
    public List<String> validate(GetTeachersRequest req) {
        List<String> error_list = new ArrayList<String>();

        return error_list;
    }
}
