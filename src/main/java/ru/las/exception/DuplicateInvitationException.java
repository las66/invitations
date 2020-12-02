package ru.las.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DuplicateInvitationException extends AppException {

    @Override
    public String getMessage() {
        return "An invitation has already been sent to one or more users";
    }

}
