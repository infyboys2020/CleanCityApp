package com.clean.springbootstarter.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clean.springbootstarter.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

	@Modifying(clearAutomatically= true)
	@Transactional
	@Query(value = "update UserEntity set password=:password where email=:email and phone=:phone")
	int updatePassword(@Param("email") String email, @Param("phone") String phone, @Param("password") String password);
	
	 
	 
	 //@Query("SELECT t FROM UserEntity t WHERE t.userId = ?1")
	UserEntity findByName(String username);
}
