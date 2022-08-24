package com.godoro.statics;

public class BankAccount {

	public final static int MONTSH_IN_A_YEAR = 12;
	private double investment;
	private static double rate;
	
	public double getAmount(int month) {
		return investment * (1 + month  * rate /(MONTSH_IN_A_YEAR * 100) );
	}
	
	public double getAmount() {
		return getAmount(MONTSH_IN_A_YEAR);
	}
	
	
	public double getInvestment() {
		return investment;
	}
	public void setInvestment(double investment) {
		this.investment = investment;
	}
	public static double getRate() {
		return rate;
	}
	public static void setRate(double rate) {
		BankAccount.rate = rate;
	}
	
	
	
}
