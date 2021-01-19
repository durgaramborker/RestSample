package com.mb.restproject.app;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NewResource {

	private String name = "";
	private int qty = 0;
	private int sprice = 0;
	private int cprice = 0;

	public int getCprice() {
		return cprice;
	}

	public void setCprice(int cprice) {
		this.cprice = cprice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return sprice;
	}

	public void setPrice(int price) {
		this.sprice = price;
	}

	@Override
	public String toString() {
		return "NewResource [name=" + name + ", qty=" + qty + ", price=" + sprice + "]";
	}

}
