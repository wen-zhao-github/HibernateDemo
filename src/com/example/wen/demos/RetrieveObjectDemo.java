package com.example.wen.demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.wen.entity.Student;

public class RetrieveObjectDemo {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		try{
			Student student = new Student("Delphi","Wang","delphi@yahoo.fr");
			//begin session transaction
			session.beginTransaction();
			//session save/retrieve
			session.save(student);
			//session commit
			session.getTransaction().commit();
			System.out.println("saving object done!");
			System.out.println("the new object saved id: "+student.getId());
			//start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			//retrieve the object
			Student temp = session.get(Student.class, student.getId());
			//commit
			session.getTransaction().commit();
			System.out.println("object retrieved: "+temp.toString());
			
		}finally{
			factory.close();
		}
		

	}

}
