package com.tonghoangvu.r2sfrontendinternship.repository;

import com.tonghoangvu.r2sfrontendinternship.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
}
