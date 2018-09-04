package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.Common;
import beans.ItemDataBeans;
import beans.UserDataBeans;
import dao.ItemDAO;
import dao.UserDAO;

/**
 * Servlet implementation class Administrator
 */
@WebServlet("/Administrator")
public class Administrator extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Administrator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			final int CATEGORY_IDENTIFICATION_NUMBER = 1;
			Common.isWhereNavAndTabActive(CATEGORY_IDENTIFICATION_NUMBER, request);

			List<UserDataBeans> userList = UserDAO.getAllUserInfo();
			request.setAttribute("userList", userList);

			List<ItemDataBeans> itemList = ItemDAO.getAllItem();
			request.setAttribute("itemList", itemList);

			request.getRequestDispatcher("WEB-INF/jsp/administrator.jsp").forward(request, response);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
