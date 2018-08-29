package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.Common;
import beans.DeliveryMethodDataBeans;
import beans.ItemDataBeans;
import dao.DeliveryMethodDAO;

/**
 * Servlet implementation class Buy
 */
@WebServlet("/Buy")
public class Buy extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Buy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		Boolean isLogin = session.getAttribute("isLogin") != null ? (Boolean) session.getAttribute("isLogin") : false;
		List<ItemDataBeans> cartItem = (ArrayList<ItemDataBeans>) session.getAttribute("cartItem");

		// ログインされているか
		if (!isLogin) {
			session.setAttribute("returnStrUrl", "Buy");
			response.sendRedirect("Signin");
		// カートにアイテムがあるか
		} else if (cartItem.size() == 0) {
			request.setAttribute("cartErrorMessage", "カートに商品がありません");
			request.getRequestDispatcher("WEB-INF/jsp/cart.jsp").forward(request, response);
		// 全て問題なければ次へ進む
		} else {
			List<DeliveryMethodDataBeans> dmdbList = DeliveryMethodDAO.getAllDeliveryMethod();
			int totalPrice = Common.getTotalItemPrice(cartItem);
			request.setAttribute("dmdbList", dmdbList);
			request.setAttribute("totalPrice", totalPrice);
			request.getRequestDispatcher("WEB-INF/jsp/buy.jsp").forward(request, response);
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
