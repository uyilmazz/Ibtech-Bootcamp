package com.ibtech.interfaces;

public class FunctionDrawer {
	
	void draw(MathFunction function,double x1, double x2, int n){
		 double dx = (x2-x1)/n;
		 for(double x = x1 ; x <= x2 ; x += dx) {
			 double y = function.evauate(x);
			 System.out.println("x: " + x + " y: " + y);
		 }
	}

}
