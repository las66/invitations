package ru.las.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidMessageException extends AppException {

    @Override
    public String getMessage() {
        return "Invite message should contain only characters in 7-bit GSM encoding or Cyrillic letters as well";
    }

}
