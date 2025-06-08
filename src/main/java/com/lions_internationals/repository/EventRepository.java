package com.lions_internationals.repository;

import com.lions_internationals.entitiy.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Events, Long> {
    List<Events> findByIsDeletedFalse();

     Events findByIdAndIsDeletedFalse(Long id);
}
