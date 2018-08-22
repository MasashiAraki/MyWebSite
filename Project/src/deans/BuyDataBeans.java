package deans;

import java.io.Serializable;
import java.util.Date;

/**
 * 購入データ
 * @author 31510007-PC
 *
 */

public class BuyDataBeans implements Serializable {
	private int id;
	private int userId;
	private int totalPrice;
	private int delivertMethodId;
	private Date buyDate;

	// コンストラクタ
	public BuyDataBeans() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getDelivertMethodId() {
		return delivertMethodId;
	}
	public void setDelivertMethodId(int delivertMethodId) {
		this.delivertMethodId = delivertMethodId;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

}
