package com.godoro.test;

public class RectangleTest4 {

	public static void main(String[] args) {
		
		Rectangle rectangle = new Rectangle(3,4);
		//rectangle.width = 5;
		//rectangle.height = 6;
		rectangle.setHeight(5);
		rectangle.setWidth(-4);
		System.out.println("Alan : "+rectangle.getArea());
		System.out.println("Perimeter : " + rectangle.getPerimeter());
	}
}
