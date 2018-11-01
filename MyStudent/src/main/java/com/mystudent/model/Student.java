package com.mystudent.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.mystudent.repository.Processor;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;
	
	
	@Column(name = "name", nullable=false)
	@Size(min = 2, max = 30, message = "Bịa tên khác đi, từ 2-30 ký tự")
	@NotNull(message = "Nhập tên vào đã, đi đâu mà vội")
	private String name;

	@Column(name = "std_group")
	@Size(min=3, max=3, message = "Tên lớp gồm 3 ký tự: D15, D16...")
	private String group;

	@Column(name = "age")
	@Min(value = 18, message = "Em chưa 18?")
	@Max(value = 60, message = "Già quá :)")
	private Short age;
	
	public Student() {
		super();
	}

	public Student(Integer id, String name, Short age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = Processor.processName(name);
	}
	
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group.toUpperCase();
	}

	public Short getAge() {
		return age;
	}

	public void setAge(Short age) {
		this.age = age;
	}
	
}
