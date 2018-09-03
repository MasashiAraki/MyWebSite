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
 * Servlet implementation class Admin_ItemAdd
 */
@WebServlet("/Admin_ItemAdd")
public class Admin_ItemAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_ItemAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<ItemCategoryBeans> ItemCategoryList = ItemCategoryDAO.getAllCategory();
			request.setAttribute("icl", ItemCategoryList);

			request.getRequestDispatcher("WEB-INF/jsp/admin_itemadd.jsp").forward(request, response);
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
		// 未実装：商品画像の処理
		try {
			request.setCharacterEncoding("UTF-8");
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			int price = Integer.parseInt(request.getParameter("price"));
			String name = request.getParameter("name");
			String detail = request.getParameter("detail");

			ItemDataBeans idb = new ItemDataBeans();
			idb.setCategoryId(categoryId);
			idb.setPrice(price);
			idb.setName(name);
			idb.setDetail(detail);

			ItemDAO.insertItem(idb);

			response.sendRedirect("Administrator");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
