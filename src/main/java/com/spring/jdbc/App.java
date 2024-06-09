package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App {
	private static ApplicationContext context;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(jdbcconfig.class);
		StudentDao std = context.getBean("studentDao", StudentDao.class);

        Student student = new Student();
        student.setSid(1234);
        student.setName("Roni");
        student.setCity("Bui");
        int res = std.insert(student);
        System.out.println("Row affected : "+res);
//		Student student = new Student();
//		student.setSid(123);
//		student.setName("Ronit");
//		student.setCity("Lko");
//		int res = std.change(student);
//		System.out.println("Row affected : " + res);
//		System.out.println("Enter id to remove : ");
//		Scanner sc = new Scanner(System.in);
//		int id = sc.nextInt();
//		int res = std.remove(id);
//		System.out.println("Row removed : " + res);
//		sc.close();
//		Student student =  std.getStudent(456);
//		System.out.println(student);
		List<Student> student1 = std.getAllStudents();
		for (Student s : student1) System.out.println(s);
	}
}
