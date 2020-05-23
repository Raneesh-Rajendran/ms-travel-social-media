package com.ms.travel.social.content.controller;

public class StaticContent {
	
	private String string1;
	private String string2;
	
	public void setString1(String string1) {
		this.string1 = string1;
	}
	public void setString2(String string2) {
		this.string2 = string2;
	}
	public String getString1() {
		return string1;
	}
	public String getString2() {
		return string2;
	}
	
	public StaticContent(String string1, String string2) {
		super();
		this.string1 = string1;
		this.string2 = string2;
	}
	public StaticContent() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "StaticContent [string1=" + string1 + ", string2=" + string2 + "]";
	}
	
	

}
