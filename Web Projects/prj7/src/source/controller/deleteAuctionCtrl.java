package source.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import source.DAO.auctionDAO;

public class deleteAuctionCtrl {
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, java.sql.SQLException {
		auctionDAO ad = new auctionDAO();
		ad.deleteAuc(new Integer(req.getParameter("id")));
		return "adminCtrl.action";
	}

}
