package com.hibernate.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Courses;
import com.hibernate.entity.Reviews;
import com.hibernate.entity.Teacher;
import com.hibernate.entity.TeacherDetails;

public class InsertCourses {
	
	public static void main(String [] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(Courses.class)
				.addAnnotatedClass(Reviews.class)
				.addAnnotatedClass(TeacherDetails.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
				try {
					session.beginTransaction();
					
					Teacher teacher=session.get(Teacher.class, 1);
					
					//create some course
					Courses c1=new Courses("Python");
					Courses c2=new Courses("Java");
					
					//add courses to teacher tablee
					teacher.add(c1);
					teacher.add(c2);
					
					session.save(c1);
					session.save(c2);
					
					session.beginTransaction().commit();
				}finally {
					//add a clean up code
					session.close();
					factory.close();
				}
	}
}
