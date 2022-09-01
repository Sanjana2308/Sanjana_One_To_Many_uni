package com.hibernate.Driver;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Courses;
import com.hibernate.entity.Reviews;
import com.hibernate.entity.Teacher;
import com.hibernate.entity.TeacherDetails;

public class InsertTeacherAndTeacherDetails {
	public static void main(String [] args) {
		// create sessioin factory
		SessionFactory factory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class)
				.addAnnotatedClass(Courses.class)
				.addAnnotatedClass(Reviews.class)
				.buildSessionFactory();
		// create factory
		Session session=factory.getCurrentSession();
		try {
			// create the objects
			Teacher teacher=new Teacher("Vikas","Jaiswal","vikas@org.com");
			Teacher t2=new Teacher("Anushka","Jaiswal","Anushka@org.com");
			Teacher t3=new Teacher("Anmol","Jaiswal","Anmol@org.com");
			Teacher t4=new Teacher("Akash","Jaiswal","Akash@org.com");
			
			TeacherDetails teacherDetails=new TeacherDetails("Mumbai","Music");
			TeacherDetails td2=new TeacherDetails("Haryana","Dancing");
			TeacherDetails td3=new TeacherDetails("Delhhi","Singing");
			TeacherDetails td4=new TeacherDetails("Dewas","Writting");
			
			//associate the object
			teacher.setTeacherDetails(teacherDetails);
			teacher.setTeacherDetails(td2);
			teacher.setTeacherDetails(td3);
			teacher.setTeacherDetails(td4);
			
			
			//start transection
			session.beginTransaction();
			
			//save the teacher
			System.out.println("Saving the teacher..."+teacher);
			session.save(teacher);
			session.save(t2);
			session.save(t3);
			session.save(t4);
			
			//commit the transecion
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
	}

}
