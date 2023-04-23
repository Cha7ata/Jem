package com.jem.jeeniso.repository;

import com.jem.jeeniso.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMediaRepository extends JpaRepository<Media,Integer> {
    boolean existsByName(String Name);

    void deleteById(Optional<Media> dto);
}
