package com.lions_internationals.repository;

import com.lions_internationals.entitiy.Admins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admins, Long> {
    Optional<Admins> findByEmail(String email);
}
