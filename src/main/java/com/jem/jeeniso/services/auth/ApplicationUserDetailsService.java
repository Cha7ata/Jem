package com.jem.jeeniso.services.auth;

import java.util.ArrayList;
import java.util.List;
import com.jem.jeeniso.dto.RoleDto;
import com.jem.jeeniso.dto.UserDto;
import com.jem.jeeniso.exception.EntityNotFoundException;
import com.jem.jeeniso.model.auth.ExtendedUser;
import com.jem.jeeniso.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.jem.jeeniso.exception.ErrorMessages.USER_NOT_FOUND_BY_EMAIL;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    private final IUserService service;

    public ApplicationUserDetailsService(IUserService service) {
        this.service = service;
    }


    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Integer x=Integer.parseInt(id);
        UserDto utilisateur = service.findById(x);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        RoleDto role=utilisateur.getRole();
        authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        return new ExtendedUser(utilisateur.getEmail(),utilisateur.getPassword(),role.getRoleName(),authorities);
    }


}
