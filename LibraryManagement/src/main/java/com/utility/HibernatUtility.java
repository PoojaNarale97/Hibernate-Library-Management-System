package com.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernatUtility {

	private static SessionFactory factory;

	 private HibernatUtility() {}

	 
	public static SessionFactory getSessionFactory() {
		if (factory != null)
			return factory;
		else {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;

	}

}

