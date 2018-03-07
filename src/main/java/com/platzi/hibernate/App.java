package com.platzi.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.platzi.hibernate.dao.TeacherDaoImpl;
import com.platzi.hibernate.model.Course;
import com.platzi.hibernate.model.Teacher;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        //Teacher teacher = new Teacher("Christian", "Avatar");
        TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
        //teacherDaoImpl.saveTeacher(teacher);
        
        
        Teacher teacher1 = teacherDaoImpl.findById(1L);
        System.out.println("findById 1 - Nombre: " + teacher1.getName());
        
        Teacher teacher2 = teacherDaoImpl.findByName("Fredy");
        System.out.println("findByName Fredy - ID: " + teacher2.getIdTeacher());
        
        teacher1.setName("Rodolfo");
        teacherDaoImpl.updateTeacher(teacher1);
        
        teacherDaoImpl.deleteTeacher( 1L );     
        
        List<Teacher> teachers =  teacherDaoImpl.findAllTeachers();
        
        for (Teacher t : teachers) {
			System.out.println("Nombre: " + t.getName());
		}
        
    }
}
