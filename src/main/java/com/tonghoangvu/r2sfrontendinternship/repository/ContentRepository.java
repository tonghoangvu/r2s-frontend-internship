package com.tonghoangvu.r2sfrontendinternship.repository;

import com.tonghoangvu.r2sfrontendinternship.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Long> {
	List<Content> findAllByUserEmail(String userEmail);
}
