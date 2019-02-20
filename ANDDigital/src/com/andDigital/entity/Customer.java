package com.andDigital.entity;

import java.util.List;

public class Customer {
	private int id;
	private List<Phones> listPhones;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Phones> getListPhones() {
		return listPhones;
	}

	public void setListPhones(List<Phones> listPhones) {
		this.listPhones = listPhones;
	}
}
