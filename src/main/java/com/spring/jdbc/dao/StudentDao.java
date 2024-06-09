package com.spring.jdbc.dao;

import java.util.List;

import com.spring.jdbc.entities.Student;

public interface StudentDao {
	int insert(Student student);
	int change(Student student);
	int remove(int sid);
	Student getStudent(int sid);
	List<Student> getAllStudents();
}
