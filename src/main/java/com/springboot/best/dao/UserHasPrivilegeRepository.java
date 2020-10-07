package com.springboot.best.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.best.model.UserHasPrivileges;
@Repository
public interface UserHasPrivilegeRepository extends JpaRepository<UserHasPrivileges, Long> {
	@Query("select u from UserHasPrivileges u where u.user.id=?1")
	List<UserHasPrivileges> findByUserId(Long id);
}
