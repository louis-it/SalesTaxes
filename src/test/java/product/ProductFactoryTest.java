package product;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class ProductFactoryTest {
	
	boolean IMPORTED = true; 
	boolean LOCAL = false; 
	

	@Test
	public void testLocalProduct() {
		LocalProduct lProd = new LocalProduct("Book", new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP) , ProductType.BOOK); 
		Product p1 = ProductFactory.getProduct( "Book", new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP) , ProductType.BOOK, LOCAL);
		assertEquals(lProd.getClass(), p1.getClass()); 
	}
	
	@Test
	public void testImportedProduct() {
		ImportedProduct iProd = new ImportedProduct("Book", new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP) , ProductType.BOOK); 
		Product p2 = ProductFactory.getProduct( "Book", new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP) , ProductType.BOOK, IMPORTED);
		assertEquals(iProd.getClass(), p2.getClass()); 
	}


}
