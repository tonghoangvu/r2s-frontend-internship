package com.tonghoangvu.r2sfrontendinternship.repository;

import com.tonghoangvu.r2sfrontendinternship.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
