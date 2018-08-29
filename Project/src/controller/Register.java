package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserDataBeans;
import dao.UserDAO;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String inputName = request.getParameter("name");
		int inputPostcode = Integer.parseInt(request.getParameter("postCode"));
		String inputAddress = request.getParameter("addr11");
		String inputLoginId = request.getParameter("loginId");
		String inputPassword = request.getParameter("password");
		String inputConfirmPassword = request.getParameter("confirmPassword");

		UserDataBeans udb = new UserDataBeans();
		udb.setName(inputName);
		udb.setPostcode(inputPostcode);
		udb.setAddress(inputAddress);
		udb.setLoginId(inputLoginId);
		udb.setPassword(inputPassword);

		String errorMessage = "";

		// 入力されているパスワードが確認用と等しいか
		if (!inputPassword.equals(inputConfirmPassword)) {
			errorMessage = "入力されたパスワードと確認用パスワードが異なります<br>";
		}

		// ログインIDの重複がないか
		if (UserDAO.isOverlapLoginId(udb.getLoginId())) {
			errorMessage += "ログインIDが重複しています。";
		}

		// 新規登録処理
		if (errorMessage.length() == 0) {
			UserDAO.InsertUser(udb);
			response.sendRedirect("Index");
		} else {
			request.setAttribute("udb", udb);
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
			dispatcher.forward(request, response);
		}
	}
}
