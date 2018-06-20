package product;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum ProductType {
	
	BOOK(Constants.TAX_FREE), 
	MEDICINE(Constants.TAX_FREE), 
	FOOD(Constants.TAX_FREE),
	OTHER(Constants.STANDARD_TAX); 

	private final BigDecimal taxRate;

	private ProductType(BigDecimal taxRate) {
		this.taxRate = taxRate; 
	}

	public BigDecimal rate(){
		return taxRate; 
	}

	private static class Constants {
		public static final BigDecimal TAX_FREE = new BigDecimal(0.0).setScale(2, RoundingMode.HALF_EVEN); 
		public static final BigDecimal STANDARD_TAX = new BigDecimal(0.1).setScale(2, RoundingMode.HALF_EVEN); 
	}
}
