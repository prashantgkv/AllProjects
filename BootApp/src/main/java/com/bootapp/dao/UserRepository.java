package com.bootapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootapp.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
