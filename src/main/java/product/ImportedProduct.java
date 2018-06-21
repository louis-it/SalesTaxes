package product;

import java.math.BigDecimal;
import static util.RoundMng.roundToNearestHalf;
import java.math.RoundingMode;

public class ImportedProduct extends Product{
	
	final private static BigDecimal TAX_ON_IMPORTED_GOODS  = new BigDecimal(0.05).setScale(2, RoundingMode.HALF_EVEN); 

	public ImportedProduct( String description, BigDecimal amount, ProductType type ){
		super( description, amount, type);	
		computeFinalTax();
		computeGrossAmount();
	}
	
	
	@Override
	protected void computeFinalTax() {		
		incrementTaxRate();
		finalTax = roundToNearestHalf(taxRate.multiply(netAmount));	
	}

	void incrementTaxRate(){
		taxRate = taxRate.add(TAX_ON_IMPORTED_GOODS);
	}


	@Override
	protected void computeGrossAmount() {
		grossAmount = netAmount.add(finalTax); 
	}

	
}
