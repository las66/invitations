package ru.las.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TooLongMessageException extends AppException {

    @Override
    public String getMessage() {
        return "Invite message too long, should be less or equal to 128 characters of 7-bit GSM charset";
    }

}
