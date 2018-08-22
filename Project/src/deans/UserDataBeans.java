package deans;

import java.io.Serializable;
import java.util.Date;

/**
 * ユーザ情報
 * @author 31510007-PC
 *
 */

public class UserDataBeans implements Serializable {
	private int id;
	private int postcode;
	private String name;
	private String address;
	private String loginId;
	private String password;
	private Date createDate;

	// コンストラクタ
	public UserDataBeans() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
