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
 * Servlet implementation class Admin_UserDataUpdate
 */
@WebServlet("/Admin_UserDataUpdate")
public class Admin_UserDataUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_UserDataUpdate() {
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

			request.getRequestDispatcher("WEB-INF/jsp/admin_userdataupdate.jsp").forward(request, response);

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
		HttpSession session = request.getSession();

		try {
			request.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(request.getParameter("id"));
			String inputName = request.getParameter("name");
			int inputPostcode = Integer.parseInt(request.getParameter("postCode"));
			String inputAddress = request.getParameter("address");
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

			// ユーザ情報更新処理
			if (errorMessage.length() == 0) {
				UserDAO.updateUser(inputUserInfo);
				response.sendRedirect("Administrator");
			} else {
				request.setAttribute("inputUserInfo", inputUserInfo);
				request.setAttribute("errorMessage", errorMessage);
				request.getRequestDispatcher("WEB-INF/jsp/admin_userdataupdate.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
