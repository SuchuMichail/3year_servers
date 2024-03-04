package validators.primitive;

import java.util.List;

public class StringValidator {

    public boolean validateIsNotNull(String str, List<String> errors, String fieldName){
        if(str == null){
            errors.add(fieldName + " is null");
            return false;
        }
        return true;
    }

    public boolean validateIsNotEmpty(String str, List<String> errors, String fieldName){
        if(str != null && str.equals("")){
            errors.add(fieldName + " is empty");
            return false;
        }
        return true;
    }

    public boolean validateIsNotMoreThanMaxlength(String str, List<String> errors, String fieldName, int MAXLENGTH){
        if(str != null && str.length() > MAXLENGTH){
            errors.add(fieldName + " is more than " + MAXLENGTH);
            return false;
        }
        return true;
    }
}
