package ru.las.dao;

import java.util.List;

public interface InvitationDao {

    void create(List<String> phoneNumbers, int author, int application);

    boolean checkInvite(String phoneNumber);

    int todayCount(int application);
}
