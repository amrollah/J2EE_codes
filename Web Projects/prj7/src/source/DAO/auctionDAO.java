package source.DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import source.entity.auction;
import source.entity.bid;
import source.entity.user;

public class auctionDAO {

	public void saveAuction(auction auc) {
		Transaction tx = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(auc);
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

			result = (auction) session.get(source.entity.auction.class, id);
			// Statement st = session..createStatement();
			// String sql="select * from foo";
			// st.executeQuery(sql);

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

	@SuppressWarnings("unchecked")
	public List<auction> listauction() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<auction> auctions = null;
		try {
			transaction = session.beginTransaction();
			auctions = session.createQuery("from auction").list();

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return auctions;
	}

	@SuppressWarnings("unchecked")
	public List<auction> listauction(user usr) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		List<auction> auctions = null;
		try {
			transaction = session.beginTransaction();
			String SQL_STRING = "FROM auction ac WHERE ac.user = '"
					+ usr.getId() + "'";
			Query query = session.createQuery(SQL_STRING);
			auctions = query.list();
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return auctions;
	}

	@SuppressWarnings("unchecked")
	public List<bid> listbids(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ArrayList<bid> bids = null;
		try {
			transaction = session.beginTransaction();
			String SQL_STRING = "FROM bid b WHERE b.auction_id = " + id;
			Query query = session.createQuery(SQL_STRING);
			bids = (ArrayList<bid>) query.list();
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bids;
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

}
