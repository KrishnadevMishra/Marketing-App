 package com.krishna.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.krishna.dto.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	@Query("select u from User u where u.id=?1")
	User findUserById(long id);

}
