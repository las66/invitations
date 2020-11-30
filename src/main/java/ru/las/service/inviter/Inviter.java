package ru.las.service.inviter;

import java.util.List;

public interface Inviter {

    void sendInvites(List<String> phoneNumbers, String message);
}
