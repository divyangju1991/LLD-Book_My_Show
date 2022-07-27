package com.scaler.lld.bookmyshow.repositories;

import com.scaler.lld.bookmyshow.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> getRoleByName(String name);
}
