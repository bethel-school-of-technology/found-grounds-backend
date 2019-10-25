package com.foundgrounds.users;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foundgrounds.users.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
