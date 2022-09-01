package com.hibernate.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Courses;
import com.hibernate.entity.Reviews;
import com.hibernate.entity.Teacher;
import com.hibernate.entity.TeacherDetails;

public class InsertCourseAndReviews {
	public static void main(String args[]) {
		
		SessionFactory factory=new Configuration()
				.configure("hibernat.cfg.xml")
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class)
				.addAnnotatedClass(Courses.class)
				.addAnnotatedClass(Reviews.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			//create the objects
			Courses c1=new Courses("C");
			Teacher teacher=session.get(Teacher.class,1);
			
			teacher.add(c1);
			//add some reviwes
			c1.addReviews(new Reviews("Good course"));
			c1.addRviews(new Reviews("Really loved it"));
			c1.addRviews(new Reviews("Awsome"));
			c1.addRviews(new Reviews("Something valuable"));
			
		}
				
	}

}
