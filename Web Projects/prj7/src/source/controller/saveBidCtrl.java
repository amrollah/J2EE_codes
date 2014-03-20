package source.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import source.DAO.bidDAO;
import source.DAO.userDAO;
import source.entity.bid;

public class saveBidCtrl {
	public String execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, java.sql.SQLException {
		bidDAO bd = new bidDAO();
		bd.saveBid(new bid(new Double(req.getParameter("bid")), new Integer(req
				.getParameter("code")), new userDAO().getUser(req
				.getRemoteUser())));
		return "userCtrl.action";
	}
}
