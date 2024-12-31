package com.project.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Blog {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 500)
    @NotNull(message = "Name cannot be null")
    private String name;

    @Column(length = 500)
    @NotNull(message = "Role cannot be null")
    private String role;
    @Column(length = 1000)
    @Pattern(regexp = "^[^\\n]*$", message = "Newline characters are not allowed in aboutwork")
    private String aboutwork;
      
    private String image; // This will store the image URL or file path

	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Blog(long id, String name, String role, String aboutwork, String image) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.aboutwork = aboutwork;
		this.image=image;
	}
	public Blog(String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
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
		this.image = image;
	}


	}


