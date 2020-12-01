package ru.las.validator;

import org.springframework.stereotype.Component;
import ru.las.exception.EmptyMessageException;
import ru.las.exception.InvalidMessageException;
import ru.las.exception.TooLongMessageException;

import java.util.regex.Pattern;

@Component
public class MessageValidator {

    private static final String GSM_MESSAGE_PATTERN = "^[A-Za-z0-9 \\r\\n@£$¥èéùìòÇØøÅå\u0394_\u03A6\u0393\u039B\u03A9\u03A0\u03A8\u03A3\u0398\u039EÆæßÉ!\"#$%&'()*+,\\-./:;<=>?¡ÄÖÑÜ§¿äöñüà^{}\\\\\\[~\\]|\u20AC]*$";
    private static final int MESSAGE_SIZE = 128;
    private final Pattern gsmMessagePattern;

    public MessageValidator() {
        this.gsmMessagePattern = Pattern.compile(GSM_MESSAGE_PATTERN);
    }

    public void validateMinSize(String message) {
        if (message == null || message.isEmpty()) {
            throw new EmptyMessageException();
        }
    }

    public void validateGsmString(String translitMessage) {
        if (!gsmMessagePattern.matcher(translitMessage).find()) {
            throw new InvalidMessageException();
        }
    }

    public void validateMaxSize(String translitMessage) {
        if (translitMessage.length() > MESSAGE_SIZE) {
            throw new TooLongMessageException();
        }
    }
}
