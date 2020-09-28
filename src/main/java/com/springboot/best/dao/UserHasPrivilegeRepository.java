package com.springboot.best.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.best.model.UserHasPrivileges;
@Repository
public interface UserHasPrivilegeRepository extends JpaRepository<UserHasPrivileges, Long> {

}
