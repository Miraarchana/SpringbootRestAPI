package io.javabrains.springbootstarter.course;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {//JPA will create table called Topic and fields as column with @Entity
	@Id
	private String id;//JPA will identify this field as primary key with @Id
	private String name;
	private String description;
	public Course() {
		
	}
	public Course(String id, String name, String description) {
		super();
		this.setId(id);
		this.setName(name);
		this.setDescription(description);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	

}
