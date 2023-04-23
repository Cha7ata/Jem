package com.jem.jeeniso.repository;


import com.jem.jeeniso.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPartnerRepository extends JpaRepository<Partner,Integer> {
    Optional<Partner> findByOrganizationName(String organisation) ;
    boolean existsByOrganizationName (String organisation);

}
