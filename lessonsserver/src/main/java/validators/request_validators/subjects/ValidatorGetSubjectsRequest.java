package validators.request_validators.subjects;

import requests.subjects.GetSubjectsRequest;
import validators.request_validators.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorGetSubjectsRequest implements IRequestValidator<GetSubjectsRequest> {
    public List<String> validate(GetSubjectsRequest req) {
        List<String> error_list = new ArrayList<String>();

        return error_list;
    }
}
