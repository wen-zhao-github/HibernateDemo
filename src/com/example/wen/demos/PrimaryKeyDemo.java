package com.example.wen.demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.wen.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		try{//create 3 students object
			Student student1 = new Student("sally","Zheng","sally@gmail.com");
			Student student2 = new Student("sarah","Lee","sara@outlook.com");
			Student student3 = new Student("bond","Lee","lee@gmail.com");
			//session start transaction
			session.beginTransaction();
			//session save
			session.save(student1);
			session.save(student2);
			session.save(student3);
			//session commit
			session.getTransaction().commit();	
			
			
		}finally{
			factory.close();
		}

	}

}
 