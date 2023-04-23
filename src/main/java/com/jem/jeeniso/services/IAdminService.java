package com.jem.jeeniso.services;

import com.jem.jeeniso.dto.MemberDto;
import com.jem.jeeniso.model.Member;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface IAdminService {



    void delete(String email);

    ArrayList<MemberDto> getUnconfirmedMembersList();

    MemberDto confirmAccount(String email);
}
