package com.example.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.FourWheeler;
import com.example.model.TwoWheeler;
import com.example.model.Vehicle;

public class Application {

	public static void main(String[] args) {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setVehicleName("Bike");
		twoWheeler.setSteeringHandle("Steering Handle");
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setSteeringWheel("Steering Wheel");
		fourWheeler.setVehicleName("Porsche");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);
		session.getTransaction().commit();
		session.close();
	}

}
