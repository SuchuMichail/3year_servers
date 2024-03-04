package validators.primitive;

import java.util.List;

public class IdValidator {
    public boolean validateId(long id, List<String> error, String fieldName){
        if(id > 0){
            return true;
        }
        error.add(fieldName + " id is not positive");
        return false;
    }
}
