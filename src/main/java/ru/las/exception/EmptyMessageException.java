package ru.las.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmptyMessageException extends AppException {

    @Override
    public String getMessage() {
        return "Invite message is missing.";
    }

}
