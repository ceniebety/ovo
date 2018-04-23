package com.example.ovo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ovo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
