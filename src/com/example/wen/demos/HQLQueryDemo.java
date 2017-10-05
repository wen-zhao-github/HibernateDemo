package com.example.wen.demos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.wen.entity.Student;

public class HQLQueryDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try{
			session.beginTransaction();
			List<Student> students = session.createQuery("from Student").getResultList();
			displayStudentList(students);
			students = session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();
			displayStudentList(students);
			session.getTransaction().commit();		
			
		}finally{
			factory.close();
		}

	}

	private static void displayStudentList(List<Student> students) {
		for(Student s:students){
			System.out.println(s.toString());
		}
	}

}
