package com.example.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.UserDetails;

public class Application {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<String> criteria = builder.createQuery(String.class);
		Root<UserDetails> root = criteria.from(UserDetails.class);
		/*criteria.select(root.get("userName")).where(builder.like(root.get("userName"), "User 1%"));*/
		criteria.select(root.get("userName")).where(builder.like(root.get("userName"), "User 1%"));
		Query<String> query = session.createQuery(criteria);
		
		List<String> userNames = query.getResultList();
		for(String userName : userNames){
			System.out.println(userName);
		}
		session.close();

	}
}