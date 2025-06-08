package com.lions_internationals.repository;

import com.lions_internationals.entitiy.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends JpaRepository<Profiles, Long> {
    List<Profiles> findByCategory(String category);

    List<Profiles> findByCategoryOrderByPriorityAsc(String categoryName);

    List<Profiles> findByPosition(String position);

    List<Profiles> findByIsDeletedFalse();
}

