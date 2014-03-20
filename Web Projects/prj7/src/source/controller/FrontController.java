package source.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import source.DAO.userDAO;
import source.entity.user;


@SuppressWarnings("serial")
public class FrontController extends HttpServlet {

	// URLs must have the form /hw7/ControllerClass.action
	// the execute() method of the ControllerClass will be called
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String className = request.getServletPath().substring(1, request.getServletPath().indexOf(".action"));
		try {
			HttpSession session = request.getSession();
			if (session != null && session.getAttribute("user") == null) {
				System.out.println(request.getRemoteUser());
				user u = new userDAO().getUser(request.getRemoteUser());
//				System.out.println("name is: " + u.getName());
				if (u != null) {
					session.setAttribute("user", u);
				}
			}
			System.out.println("Here front" + request.getServletPath() + session.getAttribute("user"));

			Class ctrlClass = Class.forName("source.controller." + className);
			Method m = ctrlClass.getMethod("execute", HttpServletRequest.class, HttpServletResponse.class);
			String forward = (String)m.invoke(ctrlClass.newInstance(), request, response);
			request.getRequestDispatcher(forward).forward(request, response);
		} catch (InvocationTargetException ex) {
			ex.printStackTrace();
			response.setContentType("text/html");
			if (ex.getTargetException() instanceof SQLException)
				response.getOutputStream().println("Error in accessing database!<p>Contact system administrator");
			else
				response.getOutputStream().println("Internal system error!<p>Contact system administrator");
		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/html");
			response.getOutputStream().println("Internal system error!<p>Contact system administrator");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
