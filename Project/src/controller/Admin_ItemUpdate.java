package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemCategoryBeans;
import beans.ItemDataBeans;
import dao.ItemCategoryDAO;
import dao.ItemDAO;

/**
 * Servlet implementation class Admin_ItemUpdate
 */
@WebServlet("/Admin_ItemUpdate")
public class Admin_ItemUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_ItemUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int itemId = Integer.parseInt(request.getParameter("item_id"));

			ItemDataBeans itemDataDetail = ItemDAO.getItem(itemId);
			request.setAttribute("idd", itemDataDetail);

			List<ItemCategoryBeans> ItemCategoryList = ItemCategoryDAO.getAllCategory();
			request.setAttribute("icl", ItemCategoryList);

			request.getRequestDispatcher("WEB-INF/jsp/admin_itemupdate.jsp").forward(request, response);

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
			request.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(request.getParameter("id"));
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			int price = Integer.parseInt(request.getParameter("price"));
			String name = request.getParameter("name");
			String detail = request.getParameter("detail");

			ItemDataBeans inputItemData = new ItemDataBeans();
			inputItemData.setId(id);
			inputItemData.setCategoryId(categoryId);
			inputItemData.setPrice(price);
			inputItemData.setName(name);
			inputItemData.setDetail(detail);

			ItemDAO.updateItem(inputItemData);

			response.sendRedirect("Administrator");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
