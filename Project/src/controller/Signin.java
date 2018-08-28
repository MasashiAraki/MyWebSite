package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.Common;
import dao.UserDAO;
import deans.UserDataBeans;

/**
 * Servlet implementation class Signin
 */
@WebServlet("/Signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/signin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");
		String inputLoginId = request.getParameter("loginId");
		String inputPassword = request.getParameter("password");

		UserDataBeans udb = UserDAO.getUserInfo(inputLoginId, inputPassword);

		if (udb != null) {
			session.setAttribute("udb_userInfo", udb);
			session.setAttribute("isLogin", true);
			String returnStrUrl = (String) Common.cutSessionAttribute(session, "returnStrUrl");
			response.sendRedirect(returnStrUrl!=null?returnStrUrl:"Index");
		} else {
			request.setAttribute("errorMessage", "入力内容が正しくありません");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/signin.jsp");
			dispatcher.forward(request, response);
		}

	}

}
