package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserDataBeans;
import dao.UserDAO;

/**
 * Servlet implementation class Admin_UserDataDelete
 */
@WebServlet("/Admin_UserDataDelete")
public class Admin_UserDataDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_UserDataDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		try {
			int userId = Integer.parseInt(request.getParameter("user_id"));

			UserDataBeans userDataDetail = UserDAO.getUserInfoBuyId(userId);
			request.setAttribute("udd", userDataDetail);

			request.getRequestDispatcher("WEB-INF/jsp/admin_userdatadelete.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			UserDAO.deleteUser(id);
			response.sendRedirect("Administrator");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
