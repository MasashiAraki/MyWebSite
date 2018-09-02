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
 * Servlet implementation class UserDataUpdate
 */
@WebServlet("/UserDataUpdate")
public class UserDataUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDataUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/jsp/userdataupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		try {
			request.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(request.getParameter("id"));
			String inputName = request.getParameter("name");
			int inputPostcode = Integer.parseInt(request.getParameter("postCode"));
			String inputAddress = request.getParameter("addr11");
			String loginId = request.getParameter("loginId");
			String inputPassword = request.getParameter("password");
			String inputConfirmPassword = request.getParameter("confirmPassword");

			UserDataBeans inputUserInfo = new UserDataBeans();
			inputUserInfo.setId(id);
			inputUserInfo.setName(inputName);
			inputUserInfo.setPostcode(inputPostcode);
			inputUserInfo.setAddress(inputAddress);
			inputUserInfo.setPassword(inputPassword);

			String errorMessage = "";

			// 入力されているパスワードが確認用と等しいか
			if (!inputPassword.equals(inputConfirmPassword)) {
				errorMessage = "入力されたパスワードと確認用パスワードが異なります<br>";
			}

			// 新規登録処理
			if (errorMessage.length() == 0) {
				UserDAO.updateUser(inputUserInfo);
				UserDataBeans udb = UserDAO.getUserInfo(loginId, inputPassword);
				session.setAttribute("udb_userInfo", udb);
				response.sendRedirect("UserData");
			} else {
				request.setAttribute("inputUserInfo", inputUserInfo);
				request.setAttribute("errorMessage", errorMessage);
				request.getRequestDispatcher("WEB-INF/jsp/userdataupdate.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}


	}

}
