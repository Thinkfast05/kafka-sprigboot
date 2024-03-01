package springboot.kafkaJson.test2.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public final class CustomException extends RuntimeException {

    public CustomException() {
        super();
    }

    public CustomException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CustomException(final String message) {
        super(message);
    }

    public CustomException(final Throwable cause) {
        super(cause);
    }
}