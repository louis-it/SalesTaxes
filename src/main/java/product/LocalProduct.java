package product;

import java.math.BigDecimal;

import util.RoundMng;

public class LocalProduct extends Product{
	

	public LocalProduct( String description, BigDecimal amount, ProductType type ){
		super( description, amount, type);
		computeFinalTax();
		computeGrossAmount();
	}

	@Override
	protected void computeFinalTax() {		
		finalTax = RoundMng.roundToNearestHalf(taxRate.multiply(netAmount));	
	}
	
	@Override
	protected void computeGrossAmount() {
		grossAmount = netAmount.add(finalTax); 
	}
	
}
