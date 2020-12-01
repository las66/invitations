package ru.las.validator;

import org.junit.Test;
import ru.las.exception.InvalidMessageException;

public class MessageValidatorTest {

    private final MessageValidator messageValidator = new MessageValidator();

    @Test
    public void validateGsmString() {
        messageValidator.validateGsmString("123qweøæ %ü");
    }

    @Test(expected = InvalidMessageException.class)
    public void validateNotGsmString() {
        messageValidator.validateGsmString("asd ☺ ad");
    }
}