package com.mySSM.dao;

import java.util.List;

import com.mySSM.model.Student;

public interface StudentDao extends BaseDao<Student>{
	public List<Student> getStudent();
}
