package source.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import source.DAO.auctionDAO;
import source.entity.bid;

public class auctionBidsCtrl {
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, java.sql.SQLException {
		List<bid> bids = new auctionDAO().listbids(new Integer(req
				.getParameter("id")));
		req.setAttribute("bids", bids);
		return "auction-bids.jsp";
	}

}
