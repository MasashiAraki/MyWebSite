package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import deans.ItemDataBeans;

public class ItemDAO {


	/**
	 *  全ての商品情報を取得
	 * @return itemList
	 */
	public static List<ItemDataBeans> getAllItem(){
		Connection con = null;
		List<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();

		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM m_item";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ItemDataBeans idb = new ItemDataBeans();
				idb.setId(rs.getInt("id"));
				idb.setPrice(rs.getInt("price"));
				idb.setCount(rs.getInt("count"));
				idb.setName(rs.getString("name"));
				idb.setCategory(rs.getString("category"));
				idb.setDetail(rs.getString("detail"));
				idb.setFileName(rs.getString("file_name"));
				itemList.add(idb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return itemList;
	}


	/**
	 * 商品IDに該当する商品情報を取得
	 * @param id 商品ID
	 * @return idb
	 */
	public static ItemDataBeans getItem (int id) {
		Connection con = null;
		PreparedStatement pStmt = null;
		try {
			con = DBManager.getConnection();
			pStmt = con.prepareStatement("SELECT * FROM m_item WHERE id = ?");
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				ItemDataBeans idb = new ItemDataBeans();
				idb.setId(rs.getInt("id"));
				idb.setPrice(rs.getInt("price"));
				idb.setCount(rs.getInt("count"));
				idb.setName(rs.getString("name"));
				idb.setCategory(rs.getString("category"));
				idb.setDetail(rs.getString("detail"));
				idb.setFileName(rs.getString("file_name"));
				return idb;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
