package product;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class ImportedProductTest {

	@Test
	public void testImportedProductTaxRateWithoutTax() {
		ImportedProduct iProd = new ImportedProduct("Yogurt", new BigDecimal(2.79).setScale(2, RoundingMode.HALF_UP) , ProductType.FOOD);
		//Net amount: 3475.66, tax:5%
		assertEquals(new BigDecimal(0.05).setScale(2, RoundingMode.HALF_UP), iProd.getTaxRate());
	}
	
	@Test
	public void testImportedProductTaxRateWithTax() {
		ImportedProduct iProd = new ImportedProduct("Online purchase", new BigDecimal(363).setScale(2, RoundingMode.HALF_UP) , ProductType.OTHER);
		//Net amount: 70.03, tax:15%
		assertEquals(new BigDecimal(0.15).setScale(2, RoundingMode.HALF_UP), iProd.getTaxRate());
	}
	
	@Test
	public void testImportedProductTaxesAmountWithoutTax() {
		ImportedProduct iProd = new ImportedProduct("The Pragmatic Programmer", new BigDecimal(3475.66).setScale(2, RoundingMode.HALF_UP) , ProductType.BOOK);
		//Net amount: 3475.66, tax:5%, tax amount:173.80 
		assertEquals(new BigDecimal(173.80).setScale(2, RoundingMode.HALF_UP), iProd.getTaxes());
	}
	
	@Test
	public void testImportedProductTaxesAmountWithTax() {
		ImportedProduct iProd = new ImportedProduct("Bluetooth speakers", new BigDecimal(70.03).setScale(2, RoundingMode.HALF_UP) , ProductType.OTHER);
		//Net amount: 70.03, tax:15%, tax amount: 10.55
		assertEquals(new BigDecimal(10.55).setScale(2, RoundingMode.HALF_UP), iProd.getTaxes());
	}
	
	@Test
	public void testImportedProductGrossWithoutTax() {
		ImportedProduct iProd = new ImportedProduct("Clean Code", new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP) , ProductType.BOOK);
		//Net amount: 12.49, tax:5%, rounded tax amount: 0.65 , Gross amount: 13.14
		assertEquals(new BigDecimal(13.14).setScale(2, RoundingMode.HALF_UP), iProd.getGrossAmount());
	}
	
	@Test
	public void testImportedProductGrossWithTax() {
		ImportedProduct iProd = new ImportedProduct("Basket ball socks", new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP) , ProductType.OTHER);
		//Net amount: 12.49, tax:15%, rounded tax amount: 1.90 , Gross amount: 14.39
		assertEquals(new BigDecimal(14.39).setScale(2, RoundingMode.HALF_UP), iProd.getGrossAmount());
	}
	


}
