package com.glaucuslogistics.assignment.model.database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.glaucuslogistics.assignment.model.Student;
/**
 * Handles Database Connectivity
 * @author Shravan
 *
 */
public class DatabaseServices {
	
	/**
	 * Retrieves all rows from the table
	 * @return List of rows
	 */
	public static List<Student> getAllStudents() {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sF = con.buildSessionFactory(reg);
		Session session = sF.openSession();

		List<Student> list = session.createCriteria(Student.class).list();		
		
		session.close();
		sF.close();
		
		return list;
	}
	
	/**
	 * Inserts a row into the table
	 * @param student The row to be inserted
	 * @return The row inserted
	 */
	public static Student insertInfo(Student student) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sF = con.buildSessionFactory(reg);
		Session session = sF.openSession();
		Transaction tr = session.beginTransaction();
		
		session.save(student);
		
		tr.commit();
		session.close();
		sF.close();
		
		return student;
	}
	
	
	/**
	 * Retrieves a particular row from table
	 * @param Primary key of the row
	 * @return Row corresponding to primary key
	 */
	public static Student getInfo(Long id) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sF = con.buildSessionFactory(reg);
		Session session = sF.openSession();
		
		Student student = (Student) session.get(Student.class, id);
		
		session.close();
		sF.close();
		
		return student;
	}
	
	/**
	 * Deletes a row from the table
	 * @param Primary key of the row
	 * @return The deleted row
	 */
	public static Student deleteInfo(Long id) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sF = con.buildSessionFactory(reg);
		Session session = sF.openSession();
		Transaction tr = session.beginTransaction();
		
		Object ob = session.get(Student.class, id);
		Student student = (Student) ob;
		session.delete(ob);
		
		tr.commit();
		session.close();
		sF.close();
		
		return student;
	}
	
	/**
	 * Updates an existing row in the table
	 * @param The row which needs to be updated
	 * @return The updated row
	 */
	public static Student updateInfo(Student student) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
		SessionFactory sF = con.buildSessionFactory(reg);
		Session session = sF.openSession();
		Transaction tr = session.beginTransaction();
		
		session.update(student);
		
		tr.commit();
		session.close();
		sF.close();
		
		return student;
	}
	
}
