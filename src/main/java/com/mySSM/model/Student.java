package com.mySSM.model;

import java.util.Date;

public class Student {
	public Integer studentId;
	public Integer number;
	public String name;
	public Integer sex;
	public Date birthday;
	public Integer gradeId;
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", number=" + number
				+ ", name=" + name + ", sex=" + sex + ", birthday=" + birthday
				+ ", gradeId=" + gradeId + "]";
	}
	public Student(Integer studentId, Integer number, String name, Integer sex,
			Date birthday, Integer gradeId) {
		super();
		this.studentId = studentId;
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.gradeId = gradeId;
	}
	public Student() {
		super();
	}
	
}
