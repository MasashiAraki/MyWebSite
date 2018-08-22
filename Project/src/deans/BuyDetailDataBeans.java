package deans;

import java.io.Serializable;

/**
 * 購入詳細
 * @author 31510007-PC
 *
 */

public class BuyDetailDataBeans implements Serializable{
	private int id;
	private int buyId;
	private int itemId;

	// コンストラクタ
	public BuyDetailDataBeans() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBuyId() {
		return buyId;
	}
	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
}
