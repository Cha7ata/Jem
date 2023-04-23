package com.jem.jeeniso.services.implementation;

import com.jem.jeeniso.dto.MemberDto;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.model.Member;
import com.jem.jeeniso.model.Role;
import com.jem.jeeniso.repository.IMemberRepository;
import com.jem.jeeniso.repository.IRoleRepository;
import com.jem.jeeniso.services.IAdminService;
import com.jem.jeeniso.services.IMemberService;
import com.jem.jeeniso.services.IRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

import static com.jem.jeeniso.exception.ErrorMessages.USER_NOT_FOUND_BY_EMAIL;

@Service
public class AdminService implements IAdminService {
    @Autowired
        private IMemberRepository memberRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IMemberService service ;
    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private IRoleService roleService;
    @Transactional
    @Override
    public void delete(String email) {

            Optional<Member> optionalUser = memberRepository.findByEmail(email);
            if(optionalUser.isEmpty()){
                throw new EntityNotFoundException(USER_NOT_FOUND_BY_EMAIL);
            }
        Member member= optionalUser.get();
            memberRepository.delete(member);


    }

    @Override
    public ArrayList<MemberDto> getUnconfirmedMembersList() {
        ArrayList<MemberDto> listUnconfirmed = new ArrayList<MemberDto>() ;
        for (MemberDto member : service.findAll()){
            if (member.getRole().getRoleName().equals("Unknown")){
                listUnconfirmed.add(member);
            }
        }
        return listUnconfirmed;
    }

    @Override
    public MemberDto confirmAccount(String email) {
        Optional<Member> optionalUser = memberRepository.findByEmail(email);
        Member member = optionalUser.get();
        Optional<Role> optionalRole =roleRepository.findByRoleName("member");
        Role role = optionalRole.get();
        member.setRole(role);
        memberRepository.save(member);
        return modelMapper.map(member,MemberDto.class);

    }

}
