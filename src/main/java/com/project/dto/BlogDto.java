package com.project.dto;

public class BlogDto {
	private long id;
	private String name;
	private String role;
	private String aboutwork;
	private String image;
	public BlogDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BlogDto(long id, String name, String role, String aboutwork ,String image) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.aboutwork = aboutwork;
		this.image=image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAboutwork() {
		return aboutwork;
	}

	public void setAboutwork(String aboutwork) {
		this.aboutwork = aboutwork;
	}
	public String getImage() {
		return image;
	}
		public void setImage(String image) {
			this.image=image;
		}
	
}
