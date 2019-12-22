package com.example.main;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.UserDetails;

public class Application {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		// hqlDemo(session);
		// paramBindingDemo(session);
		//namedParamDemo(session);
		paginationDemo(session);

		session.close();

	}

	private static void hqlDemo(Session session) {
		Query query = session.createQuery("FROM USER_DETAILS");
		List<UserDetails> users = (List<UserDetails>) query.getResultList();
		System.out.println("Number of users : " + users.size());
	}

	private static void paramBindingDemo(Session session) {

		Query query = session.createQuery("FROM USER_DETAILS WHERE USER_NAME=:userName");
		query.setParameter("userName", "User 5");

		UserDetails user = (UserDetails) query.getSingleResult();
		System.out.println("User ID for User 5 is : " + user.getUserId());

	}

	@SuppressWarnings("unchecked")
	private static void namedParamDemo(Session session) {
		Query query = session.getNamedQuery("UserDetails.byID");
		query.setParameter("id", 5);

		List<String> userNames = (List<String>) query.getResultList();

		for (String name : userNames) {
			System.out.println(name);
		}
	}

	@SuppressWarnings("unchecked")
	private static void paginationDemo(Session session) {
		Query query = session.createQuery("SELECT userName FROM USER_DETAILS");
		query.setFirstResult(5);
		query.setMaxResults(4);

		List<String> userNames = (List<String>) query.getResultList();

		for (String name : userNames) {
			System.out.println(name);
		}
	}

}
