package responses;

import responses.students.AddStudentResponse;

import java.beans.ConstructorProperties;
import java.util.List;
import java.util.Objects;

public class IntermediateResp<T> {
    private final T response;
    private final List<String> error_validation_list;
    private final Exception exception;

    @ConstructorProperties({"response","error_validation_list","exception"})
    public IntermediateResp(T response, List<String> error_validation_list, Exception exception) {
        this.response = response;
        this.error_validation_list = error_validation_list;
        this.exception = exception;
    }

    public T getResponse() {
        return response;
    }

    public List<String> getError_validation_list() {
        return error_validation_list;
    }

    public Exception getException() {
        return exception;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntermediateResp<?> that = (IntermediateResp<?>) o;
        return Objects.equals(response, that.response) && Objects.equals(error_validation_list, that.error_validation_list) && Objects.equals(exception, that.exception);
    }

    @Override
    public int hashCode() {
        return Objects.hash(response, error_validation_list, exception);
    }
}
