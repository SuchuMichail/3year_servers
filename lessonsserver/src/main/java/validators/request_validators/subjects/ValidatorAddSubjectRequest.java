package validators.request_validators.subjects;

import requests.subjects.AddSubjectRequest;
import validators.primitive.StringValidator;
import validators.request_validators.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorAddSubjectRequest implements IRequestValidator<AddSubjectRequest> {
    public List<String> validate(AddSubjectRequest req) {
        List<String> error_list = new ArrayList<String>();

        StringValidator s_v=new StringValidator();

        s_v.validateIsNotNull(req.getName(), error_list,"Name");
        s_v.validateIsNotEmpty(req.getName(), error_list,"Name");
        s_v.validateIsNotMoreThanMaxlength(req.getName(), error_list,"Name",100);

        return error_list;
    }
}
