package ru.las.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.las.dao.mapper.InvitationMapper;

import java.util.List;

@Repository
public class InvitationDaoImpl implements InvitationDao {

    private final InvitationMapper invitationMapper;

    @Autowired
    public InvitationDaoImpl(InvitationMapper invitationMapper) {
        this.invitationMapper = invitationMapper;
    }

    @Override
    public void create(List<String> phoneNumbers, int author, int application) {
        invitationMapper.create(phoneNumbers, author, application);
    }

    @Override
    public boolean checkInvite(String phoneNumber) {
        return invitationMapper.invitationCount(phoneNumber) != 0;
    }

    @Override
    public int todayCount(int application) {
        return invitationMapper.invitationTodayCount(application);
    }
}
