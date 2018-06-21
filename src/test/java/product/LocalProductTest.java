package product;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class LocalProductTest {

	@Test
	public void testLocalProductTaxRateWithoutTax() {
		LocalProduct lProd = new LocalProduct("Yogurt", new BigDecimal(2.79).setScale(2, RoundingMode.HALF_UP) , ProductType.FOOD);
		//Net amount: 3475.66, tax:0%
		assertEquals(new BigDecimal(0.0).setScale(2, RoundingMode.HALF_UP), lProd.getTaxRate());
	}
	
	@Test
	public void testLocalProductTaxRateWithTax() {
		LocalProduct lProd = new LocalProduct("Online purchase", new BigDecimal(363).setScale(2, RoundingMode.HALF_UP) , ProductType.OTHER);
		//Net amount: 70.03, tax:10%
		assertEquals(new BigDecimal(0.10).setScale(2, RoundingMode.HALF_UP), lProd.getTaxRate());
	}
	
	@Test
	public void testLocalProductTaxesAmountWithoutTax() {
		LocalProduct lProd = new LocalProduct("The Pragmatic Programmer", new BigDecimal(3475.66).setScale(2, RoundingMode.HALF_UP) , ProductType.BOOK);
		//Net amount: 3475.66, tax:0%, tax amount:0.00 
		assertEquals(new BigDecimal(0.0).setScale(2, RoundingMode.HALF_UP), lProd.getTaxes());
	}
	
	@Test
	public void testLocalProductTaxesAmountWithTax() {
		LocalProduct lProd = new LocalProduct("Bluetooth speakers", new BigDecimal(70.03).setScale(2, RoundingMode.HALF_UP) , ProductType.OTHER);
		//Net amount: 70.03, tax:10%, tax amount: 7.05
		assertEquals(new BigDecimal(7.05).setScale(2, RoundingMode.HALF_UP), lProd.getTaxes());
	}
	
	@Test
	public void testLocalProductGrossWithoutTax() {
		LocalProduct lProd = new LocalProduct("Clean Code", new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP) , ProductType.BOOK);
		//Net amount: 12.49, tax:0%, rounded tax amount: 0.00 , Gross amount: 12.49
		assertEquals(new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP), lProd.getGrossAmount());
	}
	
	@Test
	public void testLocalProductGrossWithTax() {
		LocalProduct lProd = new LocalProduct("Basket ball socks", new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP) , ProductType.OTHER);
		//Net amount: 12.49, tax:10%, rounded tax amount: 1.25 , Gross amount: 13.74
		assertEquals(new BigDecimal(13.74).setScale(2, RoundingMode.HALF_UP), lProd.getGrossAmount());
	}

}
