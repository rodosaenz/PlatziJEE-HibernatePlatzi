package com.platzi.hibernate.dao;

import java.util.List;

import com.platzi.hibernate.model.Teacher;

public class TeacherDaoImpl extends PlatziSession implements TeacherDao {
	
	private PlatziSession platziSession;

	public TeacherDaoImpl() {
		platziSession = new PlatziSession();
	}

	public void saveTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		platziSession.getSession().persist(teacher);
		platziSession.getSession().getTransaction().commit();
	}

	public void deleteTeacher(Long idTeacher) {
		// TODO Auto-generated method stub
		Teacher teacher = this.findById(idTeacher);
		platziSession.getSession().delete(teacher);
		platziSession.getSession().getTransaction().commit();
	}

	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		platziSession.getSession().update(teacher);
		platziSession.getSession().getTransaction().commit();
	}

	public List<Teacher> findAllTeachers() {
		// TODO Auto-generated method stub
		return platziSession.getSession().createQuery("from Teacher").list();
	}

	public Teacher findById(Long idTeacher) {
		// TODO Auto-generated method stub
		return platziSession.getSession().load(Teacher.class, idTeacher);
	}

	public Teacher findByName(String name) {
		// TODO Auto-generated method stub
		return (Teacher) platziSession.getSession()
				.createQuery("from Teacher where name = :name ")
				.setParameter("name", name)
				.getSingleResult();
	}

}
