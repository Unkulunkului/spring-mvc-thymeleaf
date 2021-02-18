package by.home.spring_thymeleaf.service.exception;

public class UserIsAlreadyExist extends RuntimeException{
    public UserIsAlreadyExist() {
        super();
    }

    public UserIsAlreadyExist(String message) {
        super(message);
    }

    public UserIsAlreadyExist(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIsAlreadyExist(Throwable cause) {
        super(cause);
    }

    protected UserIsAlreadyExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
