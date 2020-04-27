package com.example.ritesh.demo.model;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "All about the users")
public class User {
	private Integer id;
	@Size(min=2,message="Name Should Have Atleast 2 characters")
	@ApiModelProperty(notes ="Name Should Have Atleast 2 characters" )
	private String name;
	@Past
	@ApiModelProperty(notes ="Birth Date should be in Past" )
	private Date date;

	public Integer getId() {
		return id;
	}

	protected User() {

	}

	public User(Integer id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", date=" + date + "]";
	}

}
