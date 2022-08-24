package com.ibtecth.geometry;

public class CircleTest {
	public static void main(String[] args) {
		
		Circle circle = new Circle(3);
		
		System.out.printf("Area: %.2f\n" , circle.getArea());
		System.out.printf("Perimeter: %.2f", circle.getPerimeter());
	}	
}
