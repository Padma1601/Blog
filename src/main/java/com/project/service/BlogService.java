package com.project.service;

import java.util.List;

import com.project.dto.BlogDto;
import com.project.model.Blog;

public interface BlogService {
	List<Blog> getAllBlog();

	Blog saveBlogInfo(BlogDto blogDto);

}
