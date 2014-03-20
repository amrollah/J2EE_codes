package source.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import source.DAO.auctionDAO;
import source.entity.bid;

public class resultCtrl {
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, java.sql.SQLException {
		List<bid> bids = new auctionDAO().listbids(new Integer(req
				.getParameter("id")));
		if (bids.size() == 0) {
			req.setAttribute("winner", null);
		} else {
			bid winner = bids.get(0);
			for (bid b : bids) {
				if (b.getBid() > winner.getBid())
					winner = b;
			}
			req.setAttribute("winner", winner);
		}
		return "result.jsp";
	}

}
