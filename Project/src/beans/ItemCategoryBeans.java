package beans;

import java.io.Serializable;

public class ItemCategoryBeans implements Serializable {
	private int id;
	private String CategoryName;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}


}
