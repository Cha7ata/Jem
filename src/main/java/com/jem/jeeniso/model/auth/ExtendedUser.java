package com.jem.jeeniso.model.auth;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
public class ExtendedUser extends User {

    @Getter
    @Setter
    private String rolename;
    public ExtendedUser(String username, String password,
                        Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public ExtendedUser(String username, String password, String rolename,
                        Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.rolename = rolename;
    }
}
