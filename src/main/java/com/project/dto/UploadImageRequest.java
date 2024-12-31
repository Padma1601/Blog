package com.project.dto;

import org.springframework.web.multipart.MultipartFile;

import io.swagger.v3.oas.annotations.media.Schema;

public class UploadImageRequest {
	 @Schema(type = "string", format = "binary", description = "The image file to upload")
	    private MultipartFile image;

	    // Getter and Setter
	    public MultipartFile getImage() {
	        return image;
	    }

	    public void setImage(MultipartFile image) {
	        this.image = image;
	    }
	}

