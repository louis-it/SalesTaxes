package product;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.BeforeClass;
import org.junit.Test;

public class ProductTest {

	static Product p1 = null; 
	static Product p2 = null; 
	
	@BeforeClass
	public static void setUp(){
		p1 = new LocalProduct("Online purchase", new BigDecimal(363).setScale(2, RoundingMode.HALF_UP) , ProductType.OTHER);
		p2 = new LocalProduct("Online purchase", new BigDecimal(363).setScale(2, RoundingMode.HALF_UP) , ProductType.OTHER);
	}
	
	@Test
	public void testNewEqualsMethod() {
		assertEquals(p1, p2);
	}
	
	@Test
	public void testNewHashcodeMethod() {
		assertEquals(p1.hashCode(), p2.hashCode());
	}

}
