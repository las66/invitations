package ru.las.service;

import java.util.List;

public interface InvitationService {

    void invite(List<String> phoneNumbers, String message, int author);

    boolean checkInvite(String phoneNumber);
}
