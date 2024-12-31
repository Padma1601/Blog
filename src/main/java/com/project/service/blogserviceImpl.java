package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dto.BlogDto;
import com.project.model.Blog;
import com.project.repository.BlogRepositoryService;

@Service
public class blogserviceImpl implements BlogService {
	@Autowired
	private BlogRepositoryService blogRepositoryService;
//	  @Autowired
	    public blogserviceImpl(BlogRepositoryService blogRepository) {
	        this.blogRepositoryService = blogRepository;
	  }
	  
//@Override
//	public Blog saveBlogInfo(BlogDto blogDto) {
//		Blog blog =new Blog();
//		blog.setId(blogDto.getId());
//		blog.setName(blogDto.getName());
//		blog.setRole(blogDto.getRole());
//		blog.setAboutwork(blogDto.getAboutwork());
//		blog.setImage(blogDto.getImage());
//		return blogRepositoryService.save(blog);
//	}

	    @Override
	    public Blog saveBlogInfo(BlogDto blogDto) {
	        Blog blog = new Blog();
	        blog.setId(blogDto.getId());
	        blog.setName(blogDto.getName());
	        blog.setRole(blogDto.getRole());
	        blog.setAboutwork(blogDto.getAboutwork());

	        // Store only the file name in the database (without the full URL)
	        String fileName = blogDto.getImage().substring(blogDto.getImage().lastIndexOf("/") + 1);
	        blog.setImage(fileName);

	        return blogRepositoryService.save(blog);
	    }

	@Override
	public List<Blog> getAllBlog() {
		// TODO Auto-generated method stub
		return blogRepositoryService.findAll();
	}

	
}
