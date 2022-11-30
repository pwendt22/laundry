package com.laundry.myApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundry.myApp.models.User;

public interface UserDao extends JpaRepository<User, Long> {

}
