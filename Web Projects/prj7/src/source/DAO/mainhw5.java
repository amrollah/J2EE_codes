package source.DAO;


import source.entity.auction;
import source.entity.bid;
import source.entity.user;
import source.entity.user_roles;

public class mainhw5 {
	public static void main(String[] args) {
		user myuser = new user("kazem", "123");
		userDAO dao = new userDAO();
		dao.saveUser(myuser);

		user_roles role = new user_roles("kazem", "admin");
		user_rolesDAO dao2 = new user_rolesDAO();
		dao2.saveRole(role);
		
		auction auc = new auction("test", "now", "here", 100, true, myuser);
		auctionDAO aucdao = new auctionDAO();
		aucdao.saveAuction(auc);

		bid b = new bid(12, auc.getId(), myuser);
		bidDAO ba = new bidDAO();
		ba.saveBid(b);

//		List<auction> listauction = aucdao.listauction();
	}
}
