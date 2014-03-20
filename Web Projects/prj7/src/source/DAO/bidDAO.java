package source.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import source.entity.auction;
import source.entity.bid;

public class bidDAO {
	public void saveBid(bid bd){
		Transaction tx = null;
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			 tx = session.beginTransaction();
			session.saveOrUpdate(bd);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			e.printStackTrace();
		}
	}
	public void deleteAuc(int id) {

		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			session.delete(findByCode(id));
			tx.commit();
		} catch (HibernateException e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
	}
	public auction findByCode(int id) {
		Transaction tx = null;
		auction result = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();

			result = (auction) session.get(source.entity.bid.class, id);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null && !tx.wasCommitted())
				tx.rollback();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}

		return result;
	}

}
