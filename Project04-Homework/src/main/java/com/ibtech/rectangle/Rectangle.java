package com.ibtech.rectangle;

public class Rectangle {

	private int weight;
	private int height;

	public Rectangle() {

	}

	public Rectangle(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getArea() {
		return weight * height;
	}
	
	public int getPerimeter() {
		return (weight + height) * 2;
	}

}
