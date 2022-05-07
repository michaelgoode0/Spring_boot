package com.senla.intership.boot.api.repository;

import com.senla.intership.boot.entity.Reaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReactionRepository extends JpaRepository<Reaction,Long> {
    List<Reaction> findAll();
    @Query("select r from Reaction r where r.post.id=:id")
    Page<Reaction> findAllByPost(Pageable pageable, Long id);
}
