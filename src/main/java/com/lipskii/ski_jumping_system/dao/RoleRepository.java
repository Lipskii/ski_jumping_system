package com.lipskii.ski_jumping_system.dao;

import com.lipskii.ski_jumping_system.entity.ERole;
import com.lipskii.ski_jumping_system.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(ERole name);
}
