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
 * Servlet implementation class ItemCategory
 */
@WebServlet("/ItemCategory")
public class ItemCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int categoryId = Integer.parseInt(request.getParameter("category_id"));

			List<ItemDataBeans> itemList = ItemDAO.getItemByCategoryId(categoryId);
			request.setAttribute("itemList", itemList);

			List<ItemCategoryBeans> ItemCategoryList = ItemCategoryDAO.getAllCategory();
			request.setAttribute("icl", ItemCategoryList);

			request.getRequestDispatcher("WEB-INF/jsp/itemcategory.jsp").forward(request, response);

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
