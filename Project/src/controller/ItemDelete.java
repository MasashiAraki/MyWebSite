package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemDataBeans;


/**
 * Servlet implementation class ItemDelete
 */
@WebServlet("/ItemDelete")
public class ItemDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDelete() {
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
			String[] deleteItemIdList = request.getParameterValues("delete_item_id");
			ArrayList<ItemDataBeans> cartItem = (ArrayList<ItemDataBeans>) session.getAttribute("cartItem");

			if (deleteItemIdList != null) {
				// 削除する商品idを取得
				for (String deleteItemId : deleteItemIdList) {
					// カート内の商品を全て取り出す
					for (ItemDataBeans cartInItem : cartItem) {
						if (cartInItem.getId() == Integer.parseInt(deleteItemId)) {
							cartItem.remove(cartInItem);
							break;
						}
					}
				}
			}
			response.sendRedirect("Cart");
	}

}
