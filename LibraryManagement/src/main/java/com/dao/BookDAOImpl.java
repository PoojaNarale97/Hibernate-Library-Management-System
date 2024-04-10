package com.dao;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.Book;
import com.utility.HibernatUtility;

public class BookDAOImpl implements BookDAO{

	
	@Override
	public void saveBook(Book book) {

		SessionFactory factory = HibernatUtility.getSessionFactory();

		Session session = factory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(book);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}

	}
	@Override
	public void deleteBook(Book book) {
		SessionFactory factory = HibernatUtility.getSessionFactory();

		Session session = factory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(book);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}

	}

	@Override
	public void updateBook(Book book) {

		SessionFactory factory = HibernatUtility.getSessionFactory();

		Session session = factory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(book);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			session.close();
		}

	}

	@Override
	public Book getBook(Book book) {
		SessionFactory factory = HibernatUtility.getSessionFactory();

		Session session = factory.openSession();
		Book emp = null;

		try {

			emp = session.get(Book.class, book.getId());

		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}

		return emp;
	}

	@Override
	public List<Book> getAllBook() {
		SessionFactory factory = HibernatUtility.getSessionFactory();

		Session session = factory.openSession();

		 String hql = "FROM Book";

		  Query<Book> query = session.createQuery(hql, Book.class);
		return query.list();

	}



}
