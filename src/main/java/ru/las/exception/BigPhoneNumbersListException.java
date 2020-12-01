package ru.las.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BigPhoneNumbersListException extends AppException {

    @Override
    public String getMessage() {
        return "Too much phone numbers, should be less or equal to 16 per request";
    }

}
