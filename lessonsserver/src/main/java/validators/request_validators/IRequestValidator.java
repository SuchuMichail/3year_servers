package validators.request_validators;

import java.util.List;

public interface IRequestValidator<T> {
    List<String> validate(T req);
}
