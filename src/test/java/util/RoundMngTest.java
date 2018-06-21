package util;

import static org.junit.Assert.*;
import static util.RoundMng.roundToNearestHalf;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

public class RoundMngTest {

	@Test
	public void testRoundToNearestHalf() {
		
		BigDecimal a = new BigDecimal(75437754757.55).setScale(2, RoundingMode.HALF_UP); 
		BigDecimal b = roundToNearestHalf(new BigDecimal(75437754757.5599999)); 		
		
		BigDecimal c = new BigDecimal(10000000.00).setScale(2, RoundingMode.HALF_UP); 
		BigDecimal d = roundToNearestHalf(new BigDecimal(9999999.9999999)); 
		 
		BigDecimal e = new BigDecimal(646366.60).setScale(2, RoundingMode.HALF_UP); 
		BigDecimal f = roundToNearestHalf(new BigDecimal(646366.5799999));
		
		BigDecimal g = new BigDecimal(1.00).setScale(2, RoundingMode.HALF_UP); 
		BigDecimal h = roundToNearestHalf(new BigDecimal(1.0099999)); 
		
		BigDecimal i = new BigDecimal(75437754757.55).setScale(2, RoundingMode.HALF_UP); 
		BigDecimal l = roundToNearestHalf(new BigDecimal(75437754757.5599999)); 
		
		
		
		assertEquals(a,b);
		assertEquals(c,d);
		assertEquals(e,f);
		assertEquals(g,h);
		
	}

}
