package com.example.wen.demos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.wen.entity.Student;

public class HibernateDemo {

	public static void main(String[] args) {
		//create session factory based on config file and db table
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		try{
			//use the session to save java object			
			//create Student object
			Student student = new Student("Wen","Zhao","wen@gmail.com");
			//start a transaction
			session.beginTransaction();
			//save the student object
			session.save(student);
			System.out.println("saving the student object...");
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("save sucessfully!");
		}finally{
			factory.close();
		}

	}

}
