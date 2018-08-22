package deans;

import java.io.Serializable;

/**
 * 商品カテゴリー
 * @author 31510007-PC
 *
 */
public class ItemCategoryDataBeans implements Serializable {
	private int id;
	private String name;

	// コンストラクタ
	public ItemCategoryDataBeans() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
