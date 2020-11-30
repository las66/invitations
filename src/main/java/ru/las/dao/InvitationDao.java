package ru.las.dao;

import java.util.List;

public interface InvitationDao {

    void create(List<String> phoneNumbers, int author, int application);

}
