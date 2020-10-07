package com.springboot.best.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.best.model.Privileges;
@Repository
public interface PrivilegeRepository extends JpaRepository<Privileges, Long> {

}
