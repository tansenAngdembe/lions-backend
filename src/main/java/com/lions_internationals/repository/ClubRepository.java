package com.lions_internationals.repository;

import com.lions_internationals.entitiy.Clubs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubRepository extends JpaRepository<Clubs, Long> {
    List<Clubs> findAllByIsDeletedFalse();
}
