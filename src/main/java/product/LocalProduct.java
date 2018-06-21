package product;

import java.math.BigDecimal;
import static util.RoundMng.roundToNearestHalf;


public class LocalProduct extends Product{
	

	public LocalProduct( String description, BigDecimal amount, ProductType type ){
		super( description, amount, type);
		computeFinalTax();
		computeGrossAmount();
	}

	@Override
	protected void computeFinalTax() {		
		finalTax = roundToNearestHalf(taxRate.multiply(netAmount));	
	}
	
	@Override
	protected void computeGrossAmount() {
		grossAmount = netAmount.add(finalTax); 
	}
	
}
