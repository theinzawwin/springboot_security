package com.springboot.best.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.best.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);
}
