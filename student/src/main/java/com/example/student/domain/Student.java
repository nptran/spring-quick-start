package com.example.student.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

public class Student {
	
	@NotNull(message = "Không được bỏ trống tên")
	@Size(max = 30, min = 2, message = "Tên gồm 2 đến 30 ký tự")
	private String name;
	
	@NotNull(message = "Không được bỏ trống khoá")
	@Length(max = 3, min = 3, message = "Tên lớp gồm 3 ký tự" )
	private String group;
	
	@NotNull(message = "Không được bỏ trống tuổi")
	@Max(value=80, message = "Hãy nhập đúng tuổi của bạn :)")
	@Min(value=18, message = "Tuổi tối thiểu là 18")
	private int age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tên: "+name+" | Lớp: "+group+" | Tuổi: "+age);
		return builder.toString();
	}


}
