package com.home.pwApp.dto;

public class DirectoryDTO {
	private int id;
	private String title;
	private String description;
	private String color;
	private String icon;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
	@Override
	public String toString() {

		return getId() + "||" + getTitle() + "||" + getDescription() + "||" + getIcon() + "||" + getColor();
	}
	
}
