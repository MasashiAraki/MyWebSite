package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.ItemCategoryBeans;

public class ItemCategoryDAO {

	/**
	 * 全て商品カテゴリを取得
	 * @return List<itemCategoryBeans> 商品カテゴリのリスト
	 * @throws SQLException
	 */
	public static List<ItemCategoryBeans> getAllCategory() throws SQLException {
		Connection con = null;
		List<ItemCategoryBeans> itemCategoryList = new ArrayList<ItemCategoryBeans>();

		try {
			con = DBManager.getConnection();
			String sql =
					"SELECT * FROM m_item_category";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ItemCategoryBeans icb = new ItemCategoryBeans();
				icb.setId(rs.getInt("id"));
				icb.setCategoryName(rs.getString("category_name"));

				itemCategoryList.add(icb);
			}
			return itemCategoryList;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
}
