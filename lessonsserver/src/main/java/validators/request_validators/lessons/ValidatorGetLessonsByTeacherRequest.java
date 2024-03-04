package validators.request_validators.lessons;

import requests.lessons.GetLessonsByTeacherRequest;
import validators.request_validators.IRequestValidator;
import validators.primitive.DateValidator;
import validators.primitive.IdValidator;
import validators.primitive.StringValidator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorGetLessonsByTeacherRequest implements IRequestValidator<GetLessonsByTeacherRequest> {
    public List<String> validate(GetLessonsByTeacherRequest req) {
        List<String> error_list = new ArrayList<String>();

        DateValidator d_v=new DateValidator();
        IdValidator i_v=new IdValidator();
        StringValidator s_v=new StringValidator();

        s_v.validateIsNotNull(req.getStartDate(), error_list,"StartDate");
        s_v.validateIsNotEmpty(req.getStartDate(), error_list,"StartDate");
        s_v.validateIsNotMoreThanMaxlength(req.getStartDate(), error_list,"StartDate",100);

        d_v.validateDate(req.getStartDate(), error_list,"StartDate");

        s_v.validateIsNotNull(req.getEndDate(), error_list,"EndDate");
        s_v.validateIsNotEmpty(req.getEndDate(), error_list,"EndDate");
        s_v.validateIsNotMoreThanMaxlength(req.getEndDate(), error_list,"EndDate",100);

        d_v.validateDate(req.getEndDate(), error_list,"EndDate");

        i_v.validateId(req.getTeacherId(),error_list,"TeacherId");

        return error_list;
    }
}
