package com.laundry.myApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundry.myApp.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);

}

