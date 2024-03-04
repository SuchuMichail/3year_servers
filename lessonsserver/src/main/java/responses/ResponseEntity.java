package responses;

import java.beans.ConstructorProperties;
import java.util.Objects;

public class ResponseEntity <T>{
    private final T response;

    private final int status;

    @ConstructorProperties({"response", "status"})
    public ResponseEntity(T response, int status) {
        this.response = response;
        this.status = status;
    }

    public T getResponse() {
        return response;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseEntity<?> that = (ResponseEntity<?>) o;
        return status == that.status && Objects.equals(response, that.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(response, status);
    }
}
