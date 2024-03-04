package validators.request_validators.subjects;

import requests.subjects.EditSubjectRequest;
import validators.primitive.IdValidator;
import validators.primitive.StringValidator;
import validators.request_validators.IRequestValidator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorEditSubjectRequest implements IRequestValidator<EditSubjectRequest> {
    public List<String> validate(EditSubjectRequest req) {
        List<String> error_list = new ArrayList<String>();

        IdValidator i_v=new IdValidator();
        StringValidator s_v=new StringValidator();

        s_v.validateIsNotNull(req.getName(), error_list,"Name");
        s_v.validateIsNotEmpty(req.getName(), error_list,"Name");
        s_v.validateIsNotMoreThanMaxlength(req.getName(), error_list,"Name",100);

        i_v.validateId(req.getId(),error_list,"Id");

        return error_list;
    }
}
