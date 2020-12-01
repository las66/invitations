package ru.las.validator;

import org.springframework.stereotype.Component;
import ru.las.exception.BigPhoneNumbersListException;
import ru.las.exception.EmptyPhoneNumbersListException;
import ru.las.exception.InvalidPhoneNumbersException;

import java.util.List;
import java.util.regex.Pattern;

@Component
public class PhoneNumberValidator {

    private static final String PHONE_PATTERN = "^7\\d{10}$";
    private static final int MAX_PHONE_LIST_SIZE = 16;
    private final Pattern pattern;

    public PhoneNumberValidator() {
        this.pattern = Pattern.compile(PHONE_PATTERN);
    }

    public void validateFormat(String phoneNumber) {
        if (!pattern.matcher(phoneNumber).find()) {
            throw new InvalidPhoneNumbersException();
        }
    }

    public void validateFormat(List<String> phoneNumbers) {
        phoneNumbers.forEach(this::validateFormat);
    }

    public void validateListSize(List<String> phoneNumbers) {
        if (phoneNumbers == null || phoneNumbers.isEmpty()) {
            throw new EmptyPhoneNumbersListException();
        }
        if (phoneNumbers.size() > MAX_PHONE_LIST_SIZE) {
            throw new BigPhoneNumbersListException();
        }
    }
}
