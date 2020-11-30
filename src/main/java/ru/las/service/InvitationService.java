package ru.las.service;

import java.util.List;

public interface InvitationService {

    void sendInvites(List<String> phoneNumbers, String message, int author);

}
