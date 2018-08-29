package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import base.Common;
import base.DBManager;
import beans.UserDataBeans;

public class UserDAO {

	/**
	 * ユーザ情報の登録
	 * @param udb ユーザ情報を保持しているBeans
	 * @throws SQLException
	 */
	public static void InsertUser(UserDataBeans udb) {
		Connection con = null;
		PreparedStatement pStmt = null;
		try {
			con = DBManager.getConnection();
			pStmt = con.prepareStatement("INSERT INTO m_user(name,postcode,address,login_id,login_password,create_date) VALUES(?,?,?,?,?,?)");
			pStmt.setString(1, udb.getName());
			pStmt.setInt(2, udb.getPostcode());
			pStmt.setString(3, udb.getAddress());
			pStmt.setString(4, udb.getLoginId());
			pStmt.setString(5, Common.encryption(udb.getPassword()));
			pStmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			pStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("失敗");
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
	}


	/**
	 * ログインIDの重複を調べる
	 * @param loginId
	 * @return 重複があればtrue
	 */
	public static boolean isOverlapLoginId(String loginId) {
		Connection con = null;
		PreparedStatement pStmt = null;
		try {
			con = DBManager.getConnection();
			pStmt = con.prepareStatement("SELECT login_id FROM m_user WHERE login_id = ?");
			pStmt.setString(1, loginId);
			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	/**
	 *  ユーザ情報の有無（ログインで使用）
	 * @param loginId
	 * @param password
	 * @return ユーザ情報があればtrue
	 */
	public static UserDataBeans getUserInfo (String loginId1, String password) {
		Connection con = null;
		PreparedStatement pStmt = null;
		try {
			con = DBManager.getConnection();
			pStmt = con.prepareStatement("SELECT * FROM m_user WHERE login_id = ? and login_password = ?");
			pStmt.setString(1, loginId1);
			pStmt.setString(2, Common.encryption(password));
			ResultSet rs = pStmt.executeQuery();

			if (!rs.next()) {
				return null;
			}

			UserDataBeans udb = new UserDataBeans();
			udb.setId(rs.getInt("id"));
			udb.setPostcode(rs.getInt("postcode"));
			udb.setName(rs.getString("name"));
			udb.setAddress(rs.getString("address"));
			udb.setLoginId(rs.getString("login_id"));
			return udb;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
		return null;

	}

}
