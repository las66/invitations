package ru.las.service.inviter;

import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class LogInviter implements Inviter {

    @Override
    public void sendInvite(String phoneNumber, String message) {
        System.out.println(MessageFormat.format("Send message ''{0}'' to ''{1}''", message, phoneNumber));
    }
}
