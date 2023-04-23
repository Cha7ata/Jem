package com.jem.jeeniso.services;


import com.jem.jeeniso.dto.MemberDto;

import java.util.List;

public interface IMemberService {
    MemberDto save(MemberDto Dto);

    List<MemberDto> findAll();

}
