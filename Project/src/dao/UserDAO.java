package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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


	/**
	 * ユーザ情報を更新する
	 * @param udb 入力されたユーザ情報のBeans
	 * @throws SQLException
	 */
	public static void updateUser(UserDataBeans udb) throws SQLException {
		Connection con = null;
		PreparedStatement pStmt = null;
		try {
			con = DBManager.getConnection();
			pStmt = con.prepareStatement("UPDATE m_user SET name=?, postcode=?, address=?, login_password=? WHERE id=?;");
			pStmt.setString(1, udb.getName());
			pStmt.setInt(2, udb.getPostcode());
			pStmt.setString(3, udb.getAddress());
			pStmt.setString(4, Common.encryption(udb.getPassword()));
			pStmt.setInt(5, udb.getId());
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
	 * 全てのユーザ情報を取得
	 * @return ユーザ情報のリスト
	 * @throws SQLException
	 */
	public static List<UserDataBeans> getAllUserInfo() throws SQLException {
		Connection con = null;
		List<UserDataBeans> userList = new ArrayList<UserDataBeans>();
		try {
			con = DBManager.getConnection();
			String sql = "SELECT * FROM m_user";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				UserDataBeans udb = new UserDataBeans();
				udb.setId(rs.getInt("id"));
				udb.setName(rs.getString("name"));
				udb.setPostcode(rs.getInt("postcode"));
				udb.setAddress(rs.getString("address"));
				udb.setLoginId(rs.getString("login_id"));
				udb.setCreateDate(rs.getDate("create_date"));
				userList.add(udb);
			}
			return userList;
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
	 * idをもとにユーザ情報を検索
	 * @param id
	 * @return udb idと一致するユーザ情報
	 * @throws SQLException
	 */
	public static UserDataBeans getUserInfoBuyId(int id) throws SQLException {
		Connection con = null;
		PreparedStatement pStmt = null;
		try {
			con = DBManager.getConnection();
			pStmt = con.prepareStatement("SELECT * FROM m_user WHERE id = ?");
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();

			UserDataBeans udb = new UserDataBeans();
			if (rs.next()) {
				udb.setId(rs.getInt("id"));
				udb.setName(rs.getString("name"));
				udb.setPostcode(rs.getInt("postcode"));
				udb.setAddress(rs.getString("address"));
				udb.setLoginId(rs.getString("login_id"));
				udb.setCreateDate(rs.getDate("create_date"));
			}
			return udb;
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
	 * idをもとにユーザ情報を削除
	 * @param id ユーザID
	 * @throws SQLException
	 */
	public static void deleteUser(int id) throws SQLException {
		Connection con = null;
		PreparedStatement pStmt = null;
		try {
			con = DBManager.getConnection();
			pStmt = con.prepareStatement("DELETE FROM m_user WHERE id = ?");
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
	 * ログインIDを検索して取得
	 * @param word 検索ワード
	 * @return userList<UserDataBeans> 検索ワードに一致するユーザ情報のリスト
	 * @throws SQLException
	 */
	public static List<UserDataBeans> searchUserByLoginId(String word) throws SQLException {
		Connection con = null;
		PreparedStatement pStmt = null;
		List<UserDataBeans> userList = new ArrayList<UserDataBeans>();
		try {
			con = DBManager.getConnection();
			pStmt = con.prepareStatement(
					"SELECT * FROM m_user WHERE login_id collate utf8_unicode_ci LIKE ?");
			pStmt.setString(1, "%" + word + "%");
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				UserDataBeans udb = new UserDataBeans();
				udb.setId(rs.getInt("id"));
				udb.setName(rs.getString("name"));
				udb.setPostcode(rs.getInt("postcode"));
				udb.setAddress(rs.getString("address"));
				udb.setLoginId(rs.getString("login_id"));
				udb.setCreateDate(rs.getDate("create_date"));
				userList.add(udb);
			}
			return userList;
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
	 * 名前を検索して取得
	 * @param word 検索ワード
	 * @return userList<UserDataBeans> 検索ワードに一致するユーザ情報のリスト
	 * @throws SQLException
	 */
	public static List<UserDataBeans> searchUserByUserName(String word) throws SQLException {
		Connection con = null;
		PreparedStatement pStmt = null;
		List<UserDataBeans> userList = new ArrayList<UserDataBeans>();
		try {
			con = DBManager.getConnection();
			pStmt = con.prepareStatement(
					"SELECT * FROM m_user WHERE name collate utf8_unicode_ci LIKE ?");
			pStmt.setString(1, "%" + word + "%");
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				UserDataBeans udb = new UserDataBeans();
				udb.setId(rs.getInt("id"));
				udb.setName(rs.getString("name"));
				udb.setPostcode(rs.getInt("postcode"));
				udb.setAddress(rs.getString("address"));
				udb.setLoginId(rs.getString("login_id"));
				udb.setCreateDate(rs.getDate("create_date"));
				userList.add(udb);
			}
			return userList;
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
