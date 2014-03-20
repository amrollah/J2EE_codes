package source.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import source.entity.user_roles;

public class user_rolesDAO {
	public void saveRole(user_roles r){
		Transaction tx = null;
		try{
			Session session = HibernateUtil.getSessionFactory().openSession();
			 tx = session.beginTransaction();
			session.save(r);
			tx.commit();
		}catch(HibernateException e){
			tx.rollback();
			e.printStackTrace();
		}
	}
}
