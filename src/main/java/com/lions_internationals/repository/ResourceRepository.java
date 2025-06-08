package com.lions_internationals.repository;

import com.lions_internationals.entitiy.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<Resources, Long> {
}
