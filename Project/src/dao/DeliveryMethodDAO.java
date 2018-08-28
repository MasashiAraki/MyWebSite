package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import base.DBManager;
import deans.DeliveryMethodDataBeans;

public class DeliveryMethodDAO {

	/**
	 * 配送方法を全て取得
	 * @return  DMList
	 */
	public static List<DeliveryMethodDataBeans> getAllDeliveryMethod(){
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
	 * 配送方法をIDをもとに取得
	 * @param DeliveryMethodId
	 * @return
	 * @throws SQLException
	 */
	public static DeliveryMethodDataBeans getDeliveryMethodDataBeansByID(int DeliveryMethodId) {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"SELECT * FROM m_delivery_method WHERE id = ?");
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
