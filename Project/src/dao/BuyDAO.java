package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import base.DBManager;
import beans.BuyDataBeans;

public class BuyDAO {

	/**
	 * 購入情報登録処理
	 * @param bdb 購入情報
	 * @throws SQLException
	 */
	public static int insertBuy(BuyDataBeans bdb) throws SQLException {
		Connection con = null;
		PreparedStatement pStmt = null;
		int autoIncKey = -1;
		try {
			con = DBManager.getConnection();
			pStmt = con.prepareStatement(
					"INSERT INTO t_buy(user_id,total_price,delivery_method_id,buy_date) VALUES(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			pStmt.setInt(1, bdb.getUserId());
			pStmt.setInt(2, bdb.getTotalPrice());
			pStmt.setInt(3, bdb.getDelivertMethodId());
			pStmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			pStmt.executeUpdate();

			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				autoIncKey = rs.getInt(1);
			}
			return autoIncKey;
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
	 * 購入IDによる購入情報検索
	 * @param buyId
	 * @return BuyDataBeans
	 * @throws SQLException
	 */
	public static BuyDataBeans getBuyDataBeansByBuyId(int buyId) throws SQLException {
		Connection con = null;
		PreparedStatement pStmt = null;
		try {
			con = DBManager.getConnection();

			pStmt = con.prepareStatement(
					"SELECT * FROM t_buy"
							+ " JOIN t_delivery_method"
							+ " ON t_buy.delivery_method_id = t_delivery_method.id"
							+ " WHERE t_buy.id = ?");
			pStmt.setInt(1, buyId);

			ResultSet rs = pStmt.executeQuery();

			BuyDataBeans bdb = new BuyDataBeans();
			if (rs.next()) {
				bdb.setId(rs.getInt("id"));
				bdb.setTotalPrice(rs.getInt("total_price"));
				bdb.setBuyDate(rs.getTimestamp("buy_date"));
				bdb.setDelivertMethodId(rs.getInt("delivery_method_id"));
				bdb.setUserId(rs.getInt("user_id"));
				bdb.setDeliveryMethodPrice(rs.getInt("price"));
				bdb.setDeliveryMethodName(rs.getString("name"));
			}
			return bdb;

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
