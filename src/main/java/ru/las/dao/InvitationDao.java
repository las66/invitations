package ru.las.dao;

import java.util.List;

public interface InvitationDao {

    void create(List<String> phoneNumbers, int author, int application);

    boolean checkInvite(List<String> phoneNumbers);

    int todayCount(int application);
}
