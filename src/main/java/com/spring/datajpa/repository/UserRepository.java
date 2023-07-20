package com.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.datajpa.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	// custom method
	public User findByUserId(Long id);
	
	// custom method
	public List<User> findByAge(Integer age);
	
	// custom method
	public User findByEmail(String email);
	
	// JPQL
	@Query("select u.name from User u where u.age = ?1")
	public List<String> getNameUsingAge(Integer age);
	
	// Native query
	@Query(
			value = "select * from user_table u where u.email_id = ?1",
			nativeQuery = true
	)
	public User getUserUsingEmailNative(String email);
	
	// Named param
	@Query(
			value = "select * from user_table u where u.email_id = :email_address",
			nativeQuery = true
	)
	public User getUserUsingEmailNamedParam(@Param("email_address") String email);
	
	@Modifying
	@Transactional
	@Query(
			value = "update user_table set email_id = :email_address where name = :user_name",
			nativeQuery = true
	)
	public int updateEmailByName(@Param("email_address") String email, @Param("user_name") String userName);
	
	// custom pagination
	public Page<User> findByEmailContaining(String email, Pageable pageable);

}
