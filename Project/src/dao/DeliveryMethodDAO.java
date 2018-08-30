package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import beans.DeliveryMethodDataBeans;

public class DeliveryMethodDAO {

	/**
	 * 配送方法を全て取得
	 * @return  DMList
	 * @throws SQLException
	 */
	public static List<DeliveryMethodDataBeans> getAllDeliveryMethod() throws SQLException{
		Connection con = null;
		List<DeliveryMethodDataBeans> DMList = new ArrayList<DeliveryMethodDataBeans>();

		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM t_delivery_method";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				DeliveryMethodDataBeans dmdb = new DeliveryMethodDataBeans();
				dmdb.setId(rs.getInt("id"));
				dmdb.setPrice(rs.getInt("price"));
				dmdb.setName(rs.getString("name"));
				DMList.add(dmdb);
			}
			return DMList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}


	/**
	 * 配送方法をIDをもとに取得
	 * @param DeliveryMethodId
	 * @return
	 * @throws SQLException
	 */
	public static DeliveryMethodDataBeans getDeliveryMethodDataBeansByID(int DeliveryMethodId) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"SELECT * FROM t_delivery_method WHERE id = ?");
			st.setInt(1, DeliveryMethodId);

			ResultSet rs = st.executeQuery();

			DeliveryMethodDataBeans dmdb = new DeliveryMethodDataBeans();
			if (rs.next()) {
				dmdb.setId(rs.getInt("id"));
				dmdb.setName(rs.getString("name"));
				dmdb.setPrice(rs.getInt("price"));
			}
			return dmdb;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}

}
