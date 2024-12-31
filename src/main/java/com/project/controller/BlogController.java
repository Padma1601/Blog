package com.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.dto.BlogDto;
import com.project.dto.UploadImageRequest;
import com.project.model.Blog;
import com.project.repository.BlogRepositoryService;
import com.project.service.BlogService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperties;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/blog")
@CrossOrigin
public class BlogController {
	private final BlogService blogService;
 
	  @Value("${upload.path}") // Inject custom upload path from application.properties
	    private String uploadPath;
	@Autowired  
	public BlogController(BlogService blogService) {
		this.blogService = blogService;
	}

	@PostMapping("/saveBlog")
	public Blog createBlog(@RequestBody BlogDto blogDto) {
		
//		return blogService.save(blog);
		 return blogService.saveBlogInfo(blogDto);

	}
	

	@Operation(
	    summary = "Upload an image file",
	    description = "Endpoint to upload an image file to the server.",
	    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
	        required = true,
	        content = @Content(
	            mediaType = "multipart/form-data",
	            schema = @Schema(implementation = UploadImageRequest.class)
	        )
	    ),
	    responses = {
	        @ApiResponse(responseCode = "200", description = "Image uploaded successfully."),
	        @ApiResponse(responseCode = "400", description = "Invalid file upload request."),
	        @ApiResponse(responseCode = "500", description = "Server error while uploading the image.")
	    }
	)
	@PostMapping("/uploadImage")
	public String uploadImage(@ModelAttribute UploadImageRequest request) {
	    MultipartFile image = request.getImage();

	    try {
	        // Get the original file name
	        String originalFileName = image.getOriginalFilename();

	        // Ensure the upload directory exists
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdirs(); // Create the directory if it doesn't exist
	        }

	        // Save the file with the original name
	        File fileToSave = new File(uploadDir, originalFileName);
	        image.transferTo(fileToSave);

	        // Return the full URL to access the image
	        return "http://localhost:9000/images/" + originalFileName; // Use original file name in URL
	    } catch (IOException e) {
	        throw new RuntimeException("Failed to upload image: " + e.getMessage());
	    }
	}




	


//		@GetMapping("/getAllBlog")
//		public List<Blog> getAllBlog() {
//			List<Blog> blogs = new ArrayList<>();
//			blogs.add(new Blog("Sivadharshini", "Backend Developer",
//					"Designed and developed the database and logic to track assets.","/images/SivaDharshini.R.png"));
//			blogs.add(new Blog("Dhosheela", "Backend Developer",
//					"Developed and maintained the employee-asset tracking system.", "/images/Dhosheela.B.png"));
//			blogs.add(new Blog("Hemamalini", "Backend Developer",
//					"Developed backend logic for the Dashboard, providing real-time insights.", "/images/Hemamalini.S.png"));
//			blogs.add(new Blog("Gayathri", "UI/UX Designer",
//					"Designed the intuitive and user-friendly interface for the system.", "/images/Gayathri.M.png"));
//			blogs.add(new Blog("Premalatha", "Backend Developer",
//					"Developed backend logic for managing daily asset activities.", "/images/Premalatha.S.png"));
//			blogs.add(new Blog("Padmavathy", "Documentation and Communication",
//					"Responsible for writing blog posts and maintaining project documentation.", "/images/Padmavathy.M.png"));
//			blogs.add(new Blog("Priya", "Frontend Developer",
//					"Developed the frontend authentication system for user login and registration.", "/images/Priya.V.png"));
//			return blogService.getAllBlog();

			//return blogRepositoryService.findAll();
	@GetMapping("/getAllBlog")
	public List<Blog> getAllBlog() {
	    List<Blog> blogs = blogService.getAllBlog(); // Assuming this fetches blogs with image paths
	    
	    for (Blog blog : blogs) {
	        // Make sure the image path is full URL
	        if (blog.getImage() != null) {
	            blog.setImage("http://localhost:9000/images/" + blog.getImage());
	        }
	    }
	    return blogs;
	}


		}

	     