package com.app.main.pojo;

import javax.persistence.*;

@Entity
@Table(name="items_table")
public class Items {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	@Column(name="item_name")
	private String itemName;
	private double price;
	@OneToOne()
	private User vendor;
	private long stock;
	@Enumerated(EnumType.STRING)
	private Unit perUnit;
	private String type;
	@Column(name="image_url")
	private String imageUrl;
	
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public User getVendor() {
		return vendor;
	}
	public void setVendor(User vendor) {
		this.vendor = vendor;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	public Unit getPerUnit() {
		return perUnit;
	}
	public void setPerUnit(Unit perUnit) {
		this.perUnit = perUnit;
	}
	public Items() {
		
	}
	
	
	public Items(String itemName, double price, User vendor, long stock, Unit perUnit, String type, String imageUrl) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.vendor = vendor;
		this.stock = stock;
		this.perUnit = perUnit;
		this.type = type;
		this.imageUrl = imageUrl;
	}
	//helper methods
	public void addVendor(User vendor) {
		this.vendor = vendor;
	}
	public void removeVendor() {
		this.vendor = null;
	}
	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", vendor=" + vendor
				+ ", stock=" + stock + ", perUnit=" + perUnit + ", type=" + type + "]";
	}
	
	
}
