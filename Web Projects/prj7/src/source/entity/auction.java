package source.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import source.DAO.HibernateUtil;

public class auction {
	private int id;
	private String subject;
	private String finish_date;
	private String address;
	private double base_price;
	private boolean is_enabled;
	// private ArrayList<bid> bids;
	@SuppressWarnings("unused")
	private user user;

	public auction() {
		// TODO Auto-generated constructor stub
	}

	public auction(String name, String finish_date, String address,
			double base_price, boolean is_enabled) {
		super();
		this.subject = name;
		this.finish_date = finish_date;
		this.address = address;
		this.base_price = base_price;
		this.is_enabled = is_enabled;
		// this.bids = new ArrayList<bid>();
	}

	// public void add_bid(bid b) {
	// this.bids.add(b);
	// }

	@Override
	public String toString() {
		return "auction [id=" + id + ", name=" + subject + ", finish_date="
				+ finish_date + ", address=" + address + ", base_price="
				+ base_price + ", is_enabled=" + is_enabled + "]";
	}

	// must rewrite this methode

	// public bid getWinner() {
	// Collections.sort(this.getBids(), new Comparator<bid>() {
	//
	// public int compare(bid o1, bid o2) {
	// return (o1.getBid() > o2.getBid() ? -1 : (o1.getBid() == o2
	// .getBid() ? 0 : 1));
	// }
	// });
	// return this.getBids().get(0);
	// }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void seSubject(String subject) {
		this.subject = subject;
	}

	public String getFinish_date() {
		return finish_date;
	}

	public void setFinish_date(String finish_date) {
		this.finish_date = finish_date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getBase_price() {
		return base_price;
	}

	public void setBase_price(double base_price) {
		this.base_price = base_price;
	}

	public boolean isIs_enabled() {
		return is_enabled;
	}

	public void setIs_enabled(boolean is_enabled) {
		this.is_enabled = is_enabled;
	}

	public auction(String subject, String finish_date, String address,
			double base_price, boolean is_enabled, source.entity.user user) {
		super();
		this.subject = subject;
		this.finish_date = finish_date;
		this.address = address;
		this.base_price = base_price;
		this.is_enabled = is_enabled;
		this.user = user;
	}

	@SuppressWarnings("unchecked")
	public List<bid> listbids() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		ArrayList<bid> bids = null;
		try {
			transaction = session.beginTransaction();
			String SQL_STRING = "FROM bid b WHERE b.auction_id = '" + this.id
					+ "'";
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

}
