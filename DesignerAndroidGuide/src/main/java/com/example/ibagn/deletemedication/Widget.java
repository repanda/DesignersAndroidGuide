package com.example.ibagn.deletemedication;

public class Widget {

	private int position;
	private Integer code;
	private String name;
	private String description;
	private int img;

	public Widget(Integer code, String name, int img,String description) {

		this.code = code;
		this.name = name;
		this.img = img;
		this.position=0;
		this.description =description;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getImg() {
		return img;
	}

	public void setImg(int img) {
		this.img = img;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}