package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.BuyDetailDataBeans;
import beans.ItemDataBeans;

public class BuyDetailDAO {

	/**
	 * 購入詳細登録処理
	 * @param bddb BuyDetailDataBeans
	 * @throws SQLException
	 */
	public static void insertBuyDetail(BuyDetailDataBeans bddb) throws SQLException {
		Connection con = null;
		PreparedStatement pStmt = null;
		try {
			con = DBManager.getConnection();
			pStmt = con.prepareStatement(
					"INSERT INTO t_buy_detail(buy_id,item_id) VALUES(?,?)");
			pStmt.setInt(1, bddb.getBuyId());
			pStmt.setInt(2, bddb.getItemId());
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
	 * 購入IDによる購入詳細情報検索
	 * @param buyId
	 * @return
	 * @throws SQLException
	 */
	public static List<ItemDataBeans> getItemDataBeansListByBuyId(int buyId) throws SQLException {
		Connection con = null;
		PreparedStatement pStmt = null;
		try {
			con = DBManager.getConnection();
			pStmt = con.prepareStatement(
					"SELECT m_item.id,"
							+ " m_item.name,"
							+ " m_item.price"
							+ " FROM t_buy_detail"
							+ " JOIN m_item"
							+ " ON t_buy_detail.item_id = m_item.id"
							+ " WHERE t_buy_detail.buy_id = ?");
			pStmt.setInt(1, buyId);

			ResultSet rs = pStmt.executeQuery();
			List<ItemDataBeans> buyDetailItemList = new ArrayList<ItemDataBeans>();

			while (rs.next()) {
				ItemDataBeans idb = new ItemDataBeans();
				idb.setId(rs.getInt("id"));
				idb.setName(rs.getString("name"));
				idb.setPrice(rs.getInt("price"));
				buyDetailItemList.add(idb);
			}
			return buyDetailItemList;

		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
}
