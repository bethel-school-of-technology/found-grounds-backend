package com.foundgrounds.auth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {
  UserAuth findByUsername(String username);
}