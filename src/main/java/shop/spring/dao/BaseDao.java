package shop.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public interface BaseDao {

	SessionFactory getSessionFactory();

	void setSessionFactory(SessionFactory sessionFactory);

	Session getSession();

}
