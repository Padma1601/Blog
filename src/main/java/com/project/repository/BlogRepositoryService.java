package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.model.Blog;
@Repository
@Service
public interface BlogRepositoryService extends JpaRepository<Blog, Long> {
	

}
