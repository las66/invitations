package ru.las.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidPhoneNumbersException extends AppException {

    @Override
    public String getMessage() {
        return "One or several phone numbers do not match with international format";
    }

}
