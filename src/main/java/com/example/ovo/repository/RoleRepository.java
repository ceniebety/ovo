package com.example.ovo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ovo.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
