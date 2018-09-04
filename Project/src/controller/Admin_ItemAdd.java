package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beans.ItemCategoryBeans;
import beans.ItemDataBeans;
import dao.ItemCategoryDAO;
import dao.ItemDAO;

/**
 * Servlet implementation class Admin_ItemAdd
 */
@WebServlet("/Admin_ItemAdd")
@MultipartConfig(maxFileSize=1048576) // 最大1MB
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
			Part part = request.getPart("itemImage");

			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			int price = Integer.parseInt(request.getParameter("price"));
			String name = request.getParameter("name");
			String detail = request.getParameter("detail");
			String fileName = getFileName(part);

			// 商品画像をアップロード
			part.write(getServletContext().getRealPath("img") + "/" + fileName);

			ItemDataBeans idb = new ItemDataBeans();
			idb.setCategoryId(categoryId);
			idb.setPrice(price);
			idb.setName(name);
			idb.setDetail(detail);
			idb.setFileName(fileName);

			ItemDAO.insertItem(idb);

			response.sendRedirect("Administrator");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

    private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
	}

}
