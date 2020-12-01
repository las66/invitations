package ru.las.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmptyPhoneNumbersListException extends AppException {

    @Override
    public String getMessage() {
        return "Phone numbers is missing";
    }

}
