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

import beans.ItemDataBeans;
import dao.ItemDAO;

/**
 * Servlet implementation class ItemAdd
 */
@WebServlet("/ItemAdd")
public class ItemAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

    	int id = Integer.parseInt(request.getParameter("item_id"));
    	ItemDataBeans item = ItemDAO.getItem(id);

    	List<ItemDataBeans> cartItem = (ArrayList<ItemDataBeans>) session.getAttribute("cartItem");
    	if (cartItem == null) {
			cartItem = new ArrayList<ItemDataBeans>();
		}
    	cartItem.add(item);
    	session.setAttribute("cartItem", cartItem);

		request.getRequestDispatcher("WEB-INF/jsp/cart.jsp").forward(request, response);
	}

}
