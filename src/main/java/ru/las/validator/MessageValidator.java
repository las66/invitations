package ru.las.validator;

import org.springframework.stereotype.Component;
import ru.las.exception.EmptyMessageException;

@Component
public class MessageValidator {

    public void validateSize(String message) {
        if (message == null || message.isEmpty()) {
            throw new EmptyMessageException();
        }
    }
}
