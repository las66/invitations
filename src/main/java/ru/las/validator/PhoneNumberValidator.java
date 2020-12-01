package ru.las.validator;

import org.springframework.stereotype.Component;
import ru.las.exception.*;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class PhoneNumberValidator {

    private static final String PHONE_PATTERN = "^7\\d{10}$";
    private static final int MAX_PHONE_LIST_SIZE = 16;
    private static final int MAX_INVITATION_PER_DAY = 128;
    private final Pattern phonePattern;

    public PhoneNumberValidator() {
        this.phonePattern = Pattern.compile(PHONE_PATTERN);
    }

    public void validateFormat(String phoneNumber) {
        if (!phonePattern.matcher(phoneNumber).find()) {
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

    public void validateNumberPerDay(List<String> phoneNumbers, int todayCount) {
        if (phoneNumbers.size() + todayCount > MAX_INVITATION_PER_DAY) {
            throw new TooMachInvitationsPerDayException();
        }
    }

    public void validateDuplicates(List<String> phoneNumbers) {
        if (phoneNumbers.size() != new HashSet<>(phoneNumbers).size()) {
            throw new DuplicateNumberException();
        }
    }
}
