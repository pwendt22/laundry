package com.laundry.myApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laundry.myApp.models.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

}
