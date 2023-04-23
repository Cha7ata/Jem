package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.Member;
import com.jem.jeeniso.model.Role;
import com.jem.jeeniso.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMemberRepository extends JpaRepository<Member,Integer> {

    Optional<Member> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<Member> findByRole(Role role);

}

