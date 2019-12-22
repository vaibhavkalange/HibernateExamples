package com.example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.UserDetails;
import com.example.model.Vehicle;

public class Application {

	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		user.setUserName("Vaibhav");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.persist(user);
		/*session.save(vehicle);
		session.save(vehicle2);*/
		session.getTransaction().commit();
		session.close();
	}

}
