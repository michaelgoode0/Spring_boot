package com.senla.intership.boot.security.api.repository;

import com.senla.intership.boot.entity.User;
import com.senla.intership.boot.util.GenericDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends GenericDao<User> {
    Page<User> getByNameCriteria(String username, Pageable pageable);
    User getByNameWithRoles(String username);
    User getByName(String username);
    User getEagerJPQL(Long userId);
    User getEagerCriteria(Long userId);
    User getEagerGraph(Long id);
    User getByLoginJdbc(String login);
    List<User> getAll();
}
