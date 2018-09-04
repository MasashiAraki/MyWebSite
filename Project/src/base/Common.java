package base;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.ItemDataBeans;

public class Common {

	/**
	 * パスワードを暗号化
	 * @param target 入力したパスワード
	 * @return 暗号化したパスワード
	 */
	public static String encryption(String target) {
		MessageDigest md = null;
		StringBuffer buf = new StringBuffer();
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(target.getBytes());
			byte[] digest = md.digest();

			for (int i = 0; i < digest.length; i++) {
				buf.append(String.format("%02x", digest[i]));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return buf.toString();
	}

	/**
	 * 商品の合計金額を算出する
	 * @param cartItem
	 * @return total
	 */
	public static int getTotalItemPrice(List<ItemDataBeans> cartItem) {
		int total = 0;
		for (ItemDataBeans item : cartItem) {
			total += item.getPrice();
		}
		return total;
	}

	/**
	 *  セッションから指定データを取得（削除も一緒に行う）
	 * @param session
	 * @param str
	 * @return
	 */
	public static Object cutSessionAttribute(HttpSession session, String str) {
		Object test = session.getAttribute(str);
		session.removeAttribute(str);
		return test;
	}

	/**
	 * administrator.jspの各ナビとタブを、どちらを初期表示にさせるか判別
	 * @param id
	 * @param request
	 */
	public static void isWhereNavAndTabActive(int id ,HttpServletRequest request) {
		String isUserNavActive = "";
		String isItemNavActive = "";
		String isUserTabActive = "";
		String isItemTabActive = "";

		switch (id) {
			case 1:
				isUserNavActive = "active";
				isUserTabActive = "show active";
				break;

			case 2:
				isItemNavActive = "active";
				isItemTabActive = "show active";
				break;
		}

		request.setAttribute("isUserNavActive", isUserNavActive);
		request.setAttribute("isItemNavActive", isItemNavActive);
		request.setAttribute("isUserTabActive", isUserTabActive);
		request.setAttribute("isItemTabActive", isItemTabActive);
	}

	/**
	 * administrator.jspの検索カテゴリーのどちらを初期選択にするか
	 * @param id
	 * @param request
	 */
	public static void isWhereSearchCategoryActive(int id ,HttpServletRequest request) {
		String isLoginIdActive = "";
		String isNameActive = "";

		switch (id) {
			case 1:
				isLoginIdActive = "selected";
				break;

			case 2:
				isNameActive = "selected";
				break;
		}

		request.setAttribute("isLoginIdActive", isLoginIdActive);
		request.setAttribute("isNameActive", isNameActive);
	}
}
