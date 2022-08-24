package com.ibtech.interfaces;

public class Test {

	public static void main(String[] args) {
		
		IdentityFunction f1 = new IdentityFunction();
		FunctionDrawer drawer = new FunctionDrawer();
		drawer.draw(f1, 10, 15, 100);
		
		System.out.println("\n****************** SinusoidalPolynomial *******************\n");
		SinusoidalPolynomial sinusoidal = new SinusoidalPolynomial(3, 5, 7);
		drawer.draw(sinusoidal, -Math.PI, Math.PI, 100);
		
		System.out.println("\n****************** QuadraticPolynomial *******************\n");
		QuadraticPolynomial quadratic = new QuadraticPolynomial(3, 5, 7);
		drawer.draw(quadratic, -5, 5, 100);
	}
}
