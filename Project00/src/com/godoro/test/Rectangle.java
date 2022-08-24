package com.godoro.test;

public class Rectangle {
	
	private int width;
	private int height;
	
	Rectangle(int width,int height){
		this.width = width;
		this.height = height;
	}
	
	Rectangle(){
		this(1,1);
	}
	
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if(width < 0) {
			this.width = -width;
		}else {
			this.width = width;
		}
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if(height<0) {
			throw new IllegalArgumentException("Yükseklik eksi olamaz : " + height);
		}else {
			this.height = height;
		}
	}

	
	int getArea() {
		return width * height;
	}
	
	int getPerimeter(){
		return 2*(width + height);
	}
}
