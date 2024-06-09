package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;
@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Student student) {
		String query = "insert into student(sid,name,city) values(?,?,?)";
		int res = this.jdbcTemplate.update(query, student.getSid(), student.getName(), student.getCity());

		return res;
	}

	@Override
	public int change(Student student) {
		String query = "update student set name=?, city=? where sid=?";
		int res = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getSid());

		return res;
	}

	@Override
	public int remove(int sid) {
		String query = "delete from student where sid=?";
		int res = this.jdbcTemplate.update(query, sid);
		return res;
	}

	@Override
	public Student getStudent(int sid) {
		String query = "select * from student where sid=?";
		RowMapper<Student> rowMapper = new rowMapperImpl();
		Student student = (Student) this.jdbcTemplate.queryForObject(query, rowMapper, sid);
//		new RowMapper<Object>() {
//			@Override
//			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Student student = new Student();
//				student.setSid(rs.getInt(1));
//				student.setName(rs.getString(2));
//				student.setCity(rs.getString(3));
//				return student;
//			}
//		}

		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		String query = "select * from student";
		List<Student> student = this.jdbcTemplate.query(query, new rowMapperImpl());
		return student;
	}

}
