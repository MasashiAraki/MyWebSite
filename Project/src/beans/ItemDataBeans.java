package beans;

import java.io.Serializable;

/**
 * アイテム
 * @author 31510007-PC
 *
 */

public class ItemDataBeans implements Serializable {
	private int id;
	private int price;
	private String name;
	private String category;
	private String detail;
	private String fileName;

	// コンストラクタ
	public ItemDataBeans() {
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
