package com.safetia.nothwind.dto;

public class MemberDTO {
	private String title;
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private String name;
	private String tel;

	public MemberDTO() {

	}

	public MemberDTO(String Name, String Tel) {
		this.name = Name;
		this.tel = Tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
