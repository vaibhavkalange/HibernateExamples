package com.example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.UserDetails;

public class Application {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		UserDetails user = session.get(UserDetails.class, 1);

		session.close();
		
		Session session2 = sessionFactory.openSession();
		
		UserDetails user2 = session2.get(UserDetails.class, 1);

		session.close();


	}
}
