package com.laundry.myApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundry.myApp.models.User;

public interface UsuarioRepository extends JpaRepository<User, Long> {
	static User findByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}
}

