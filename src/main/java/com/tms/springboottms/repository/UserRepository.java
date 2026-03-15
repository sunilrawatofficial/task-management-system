package com.tms.springboottms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tms.springboottms.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByUserName(String username);
}
