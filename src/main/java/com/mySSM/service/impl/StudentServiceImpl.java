package com.mySSM.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mySSM.dao.StudentDao;
import com.mySSM.model.Student;
import com.mySSM.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	@Override
	public List<Student> getStudentList() {
		// TODO Auto-generated method stub
		return studentDao.getStudent();
	}
	
}
