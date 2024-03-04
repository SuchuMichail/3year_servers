package validators.request_validators.student_groups;

import requests.student_groups.GetStudentGroupsRequest;
import validators.request_validators.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorGetStudentGroupsRequest implements IRequestValidator<GetStudentGroupsRequest> {
    public List<String> validate(GetStudentGroupsRequest req) {
        List<String> error_list = new ArrayList<String>();



        return error_list;
    }
}
