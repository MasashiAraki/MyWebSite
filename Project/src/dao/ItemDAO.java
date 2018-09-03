package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.ItemDataBeans;

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
			String sql =
					"SELECT * FROM m_item JOIN m_item_category ON m_item.category_id = m_item_category.id";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ItemDataBeans idb = new ItemDataBeans();
				idb.setId(rs.getInt("id"));
				idb.setPrice(rs.getInt("price"));
				idb.setName(rs.getString("name"));
				idb.setCategoryId(rs.getInt("category_id"));
				idb.setDetail(rs.getString("detail"));
				idb.setFileName(rs.getString("file_name"));
				idb.setCategoryName(rs.getString("category_name"));
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
			pStmt = con.prepareStatement(
					"SELECT * FROM m_item"
							+ " JOIN m_item_category"
							+ " ON m_item.category_id = m_item_category.id"
							+ " WHERE m_item.id = ?");
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();

			if (rs.next()) {
				ItemDataBeans idb = new ItemDataBeans();
				idb.setId(rs.getInt("id"));
				idb.setPrice(rs.getInt("price"));
				idb.setName(rs.getString("name"));
				idb.setCategoryId(rs.getInt("category_id"));
				idb.setDetail(rs.getString("detail"));
				idb.setFileName(rs.getString("file_name"));
				idb.setCategoryName(rs.getString("category_name"));
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

	/**
	 * 商品情報を更新する
	 * @param idb
	 * @throws SQLException
	 */
	public static void updateItem(ItemDataBeans idb) throws SQLException {
		Connection con = null;
		PreparedStatement pStmt = null;
		try {
			con = DBManager.getConnection();
			pStmt = con.prepareStatement("UPDATE m_item SET name=?, category_id=?, detail=?, price=? WHERE id=?;");
			pStmt.setString(1, idb.getName());
			pStmt.setInt(2, idb.getCategoryId());
			pStmt.setString(3, idb.getDetail());
			pStmt.setInt(4, idb.getPrice());
			pStmt.setInt(5, idb.getId());

			pStmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * 商品IDに該当する商品レコードを削除
	 * @param id
	 * @throws SQLException
	 */
	public static void deleteItem(int id) throws SQLException {
		Connection con = null;
		PreparedStatement pStmt = null;
		try {
			con = DBManager.getConnection();
			pStmt = con.prepareStatement("DELETE FROM m_item WHERE id=?;");
			pStmt.setInt(1, id);

			pStmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * 商品を新規登録する
	 * @param idb
	 * @throws SQLException
	 */
	public static void insertItem(ItemDataBeans idb) throws SQLException {
		Connection con = null;
		PreparedStatement pStmt = null;
		try {
			con = DBManager.getConnection();
			pStmt = con.prepareStatement("INSERT INTO m_item (name,category_id,detail,price,file_name) VALUE (?,?,?,?,?)");
			pStmt.setString(1, idb.getName());
			pStmt.setInt(2, idb.getCategoryId());
			pStmt.setString(3, idb.getDetail());
			pStmt.setInt(4, idb.getPrice());
			pStmt.setString(5, idb.getFileName());
			pStmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * カテゴリーIDと一致する全ての商品を取得
	 * @param categoryId
	 * @return itemList<itemDataBeans> 商品のリスト
	 * @throws SQLException
	 */
	public static List<ItemDataBeans> getItemByCategoryId(int categoryId) throws SQLException {
		Connection con = null;
		PreparedStatement pStmt = null;
		List<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();
		try {
			con = DBManager.getConnection();
			pStmt = con.prepareStatement(
					"SELECT * FROM m_item"
							+ " JOIN m_item_category"
							+ " ON m_item.category_id = m_item_category.id"
							+ " WHERE m_item.category_id = ?");
			pStmt.setInt(1, categoryId);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				ItemDataBeans idb = new ItemDataBeans();
				idb.setId(rs.getInt("id"));
				idb.setName(rs.getString("name"));
				idb.setCategoryId(rs.getInt("category_id"));
				idb.setDetail(rs.getString("detail"));
				idb.setPrice(rs.getInt("price"));
				idb.setFileName(rs.getString("file_name"));
				itemList.add(idb);
			}
			return itemList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

	/**
	 * 商品名を検索
	 * @param word 検索ワード
	 * @return itemList<ItemDataBeans> 検索ワードに該当する商品のリスト
	 * @throws SQLException
	 */
	public static List<ItemDataBeans> searchItem(String word) throws SQLException {
		Connection con = null;
		PreparedStatement pStmt = null;
		List<ItemDataBeans> itemList = new ArrayList<ItemDataBeans>();
		try {
			con = DBManager.getConnection();
			pStmt = con.prepareStatement(
					"SELECT * FROM m_item"
							+ " JOIN m_item_category"
							+ " ON m_item.category_id = m_item_category.id"
							+ " WHERE name collate utf8_unicode_ci LIKE ?");
			pStmt.setString(1, "%" + word + "%");
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				ItemDataBeans idb = new ItemDataBeans();
				idb.setId(rs.getInt("id"));
				idb.setPrice(rs.getInt("price"));
				idb.setName(rs.getString("name"));
				idb.setCategoryId(rs.getInt("category_id"));
				idb.setDetail(rs.getString("detail"));
				idb.setFileName(rs.getString("file_name"));
				idb.setCategoryName(rs.getString("category_name"));
				itemList.add(idb);
			}
			return itemList;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}


}
