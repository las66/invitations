package ru.las.service.inviter;

import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class LogInviter implements Inviter {

    @Override
    public void sendInvites(List<String> phoneNumbers, String message) {
        for (String phoneNumber : phoneNumbers) {
            System.out.println(MessageFormat.format("Send message ''{0}'' to ''{1}''", message, phoneNumber));
        }
    }
}
