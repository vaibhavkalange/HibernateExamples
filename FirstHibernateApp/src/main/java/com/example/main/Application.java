package com.example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.Address;
import com.example.model.UserDetails;

public class Application {

	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		Address address = new Address();
		address.setStreet("Undri");
		address.setCity("Pune");
		address.setPin(411060);
		address.setState("Maharashtra");
		
		Address address2 = new Address();
		address2.setStreet("Rajeev Nagar");
		address2.setCity("Nashik");
		address2.setPin(422009);
		address2.setState("Maharashtra");
		
		user.setUserName("Vaibhav");
		user.getAddresses().add(address);
		user.getAddresses().add(address2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user=null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails)session.get(UserDetails.class, 1);
		session.close();
		System.out.println(user.getAddresses().size());
		
		
	}

}
