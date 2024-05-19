package exceptions.service_exceptions;

public class NotFoundService extends Exception {
    public NotFoundService() {
        super();
    }

    public NotFoundService(String message) {
        super(message);
    }

    public NotFoundService(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundService(Throwable cause) {
        super(cause);
    }

    protected NotFoundService(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
