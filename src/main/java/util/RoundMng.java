package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundMng {

	final static BigDecimal CONSTANT = new BigDecimal(20.0).setScale(2); 
	
	public static double roundToNearestHalf(double amount){

		return Math.round(amount * 20.0) / 20.0;
	}

	public static BigDecimal roundToNearestHalf(BigDecimal amount){
		System.out.println(amount.multiply(CONSTANT));
		return (amount.multiply(CONSTANT).setScale(0, RoundingMode.HALF_EVEN)).divide(CONSTANT,2, RoundingMode.HALF_EVEN); 
	}

	public static void main(String[] args){
		System.out.println(roundToNearestHalf(new BigDecimal(75437754757.5599999)));
		System.out.println(roundToNearestHalf(75437754757.376346));
		
	}


}

