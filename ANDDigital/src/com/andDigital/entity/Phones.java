package com.andDigital.entity;

public class Phones
{
	private String phone;
	private boolean activated;

	public Phones(String p, boolean a) {
		this.phone = p;
		this.activated = a;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}
}
