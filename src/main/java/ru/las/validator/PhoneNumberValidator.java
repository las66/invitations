package ru.las.validator;

import org.springframework.stereotype.Component;
import ru.las.exception.InvalidPhoneNumbersException;

import java.util.List;
import java.util.regex.Pattern;

@Component
public class PhoneNumberValidator {

    private static final String PHONE_PATTERN = "^7\\d{10}$";
    private final Pattern pattern;

    public PhoneNumberValidator() {
        this.pattern = Pattern.compile(PHONE_PATTERN);
    }

    public void validateFormat(String number) {
        if (!pattern.matcher(number).find()) {
            throw new InvalidPhoneNumbersException();
        }
    }

    public void validateFormat(List<String> numbers) {
        numbers.forEach(this::validateFormat);
    }
}
