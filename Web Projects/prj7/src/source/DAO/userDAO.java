package source.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import source.entity.user;

public class userDAO {
	public void saveUser(user usr) {
		Transaction tx = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(usr);
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	public user getUser(String username) {
		Transaction tx = null;
		user u = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			String SQL_STRING = "FROM user b WHERE b.name = " + username;
            Query query = session.createQuery(SQL_STRING);
            u = (user) query.uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		}
		return u;
	}
}
