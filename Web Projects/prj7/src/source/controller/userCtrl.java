package source.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import source.DAO.auctionDAO;
import source.entity.auction;

public class userCtrl {
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, java.sql.SQLException {
		auctionDAO ad = new auctionDAO();
		Collection<source.entity.auction> auctions = ad.listauction();
		for(auction ac:auctions){
			if (!ac.isIs_enabled())
				auctions.remove(ac);
		}
		req.setAttribute("auctions", auctions);
		return "user.jsp";
	}

}
