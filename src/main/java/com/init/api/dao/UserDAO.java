package com.init.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.api.entidades.User;

public interface UserDAO extends JpaRepository<User, Long>{
}
