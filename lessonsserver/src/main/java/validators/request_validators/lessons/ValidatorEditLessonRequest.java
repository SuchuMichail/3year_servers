package validators.request_validators.lessons;

import requests.lessons.EditLessonRequest;
import validators.request_validators.IRequestValidator;
import validators.primitive.DateValidator;
import validators.primitive.IdValidator;
import validators.primitive.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorEditLessonRequest implements IRequestValidator<EditLessonRequest> {
    public List<String> validate(EditLessonRequest req) {
        List<String> error_list = new ArrayList<String>();

        DateValidator d_v=new DateValidator();
        IdValidator i_v=new IdValidator();
        StringValidator s_v=new StringValidator();

        s_v.validateIsNotNull(req.getStartDate(),error_list,"StartDate");
        s_v.validateIsNotEmpty(req.getStartDate(),error_list,"StartDate");
        s_v.validateIsNotMoreThanMaxlength(req.getStartDate(),error_list,"StartDate",100);

        d_v.validateDate(req.getStartDate(),error_list,"StartDate");

        s_v.validateIsNotNull(req.getEndDate(),error_list,"EndDate");
        s_v.validateIsNotNull(req.getEndDate(),error_list,"EndDate");
        s_v.validateIsNotNull(req.getEndDate(),error_list,"EndDate");

        d_v.validateDate(req.getEndDate(),error_list,"EndDate");

        i_v.validateId(req.getGroupId(),error_list,"GroupId");
        i_v.validateId(req.getTeacherId(),error_list,"TeacherId");
        i_v.validateId(req.getId(),error_list,"Id");

        return error_list;
    }
}
