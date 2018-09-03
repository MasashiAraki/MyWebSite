package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserDataBeans;
import dao.UserDAO;

/**
 * Servlet implementation class Admin_UserSearch
 */
@WebServlet("/Admin_UserSearch")
public class Admin_UserSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_UserSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int categoryId = Integer.parseInt(request.getParameter("searchUserCategoryId"));
			String searchWord = request.getParameter("searchWord");

			switch (categoryId) {
			case 1:
				List<UserDataBeans> userList = UserDAO.searchUserByLoginId(searchWord);
				request.setAttribute("userList", userList);
				multipleRequest(request, response);
				break;

			case 2:
				List<UserDataBeans> userList2 = UserDAO.searchUserByUserName(searchWord);
				request.setAttribute("userList", userList2);
				multipleRequest(request, response);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void multipleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String activeCheckUser = "active";
		String activeCheckItem = "";

		request.setAttribute("activeCheckUser", activeCheckUser);
		request.setAttribute("activeCheckItem", activeCheckItem);
		request.getRequestDispatcher("WEB-INF/jsp/administrator.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
