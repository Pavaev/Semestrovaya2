package project.exception;

import java.io.IOException;

public class JsonException extends IOException {


    public JsonException(String message, Throwable cause) {
        super(message, cause);
    }
}
