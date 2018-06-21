package util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundMng {

	final static BigDecimal CONSTANT = new BigDecimal(20.0).setScale(2); 
	

	public static BigDecimal roundToNearestHalf(BigDecimal amount){
		return (amount.multiply(CONSTANT).setScale(0, RoundingMode.HALF_UP)).divide(CONSTANT,2, RoundingMode.HALF_EVEN); 
	}

}

