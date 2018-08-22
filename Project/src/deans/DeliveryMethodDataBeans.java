package deans;

import java.io.Serializable;

/**
 * 配送方法
 * @author 31510007-PC
 *
 */

public class DeliveryMethodDataBeans implements Serializable {
	private int id;
	private int price;
	private String name;

	// コンストラクタ
	public DeliveryMethodDataBeans() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
