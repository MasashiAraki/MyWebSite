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
import dao.DeliveryMethodDAO;
import deans.BuyDataBeans;
import deans.DeliveryMethodDataBeans;
import deans.ItemDataBeans;

/**
 * Servlet implementation class BuyConfirm
 */
@WebServlet("/BuyConfirm")
public class BuyConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		int inputDeliveryMethodId = Integer.parseInt(request.getParameter("delivery_method_id"));
		DeliveryMethodDataBeans userSelectDMB = DeliveryMethodDAO.getDeliveryMethodDataBeansByID(inputDeliveryMethodId);

		List<ItemDataBeans> cartItemList = (ArrayList<ItemDataBeans>) session.getAttribute("cartItem");
		int totalPrice = Common.getTotalItemPrice(cartItemList);

		BuyDataBeans bdb = new BuyDataBeans();
		bdb.setUserId((int) session.getAttribute("udb_userInfo.getId"));
		bdb.setTotalPrice(totalPrice);
		bdb.setDelivertMethodId(userSelectDMB.getId());
		bdb.setDeliveryMethodName(userSelectDMB.getName());
		bdb.setDeliveryMethodPrice(userSelectDMB.getPrice());

		session.setAttribute("bdb", bdb);

		request.getRequestDispatcher("WEB-INF/jsp/buyconfirm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
