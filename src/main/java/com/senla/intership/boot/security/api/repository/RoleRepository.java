package com.senla.intership.boot.security.api.repository;

import com.senla.intership.boot.security.enums.RoleName;
import com.senla.intership.boot.security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findRoleByRoleName(RoleName roleName);
}
