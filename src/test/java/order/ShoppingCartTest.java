package order;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Before;
import org.junit.Test;

import product.Product;
import product.ProductFactory;
import product.ProductType;

public class ShoppingCartTest {

	final static boolean IMPORTED = true; 
	final static boolean LOCAL = false; 
	
	ShoppingCart myCart; 
	
	@Before
	public void setUpCart(){
		myCart = new ShoppingCart(); 
	}
	
	@Test
	public void testCase1TotalAmount() {
		Product p1 = ProductFactory.getProduct( "Book", new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP) , ProductType.BOOK, LOCAL);
		Product p2 = ProductFactory.getProduct( "music CD", new BigDecimal(14.99).setScale(2, RoundingMode.HALF_UP), ProductType.OTHER, LOCAL); 
		Product p3 = ProductFactory.getProduct( "chocolate bar", new BigDecimal(0.85).setScale(2, RoundingMode.HALF_UP), ProductType.FOOD, LOCAL); 
		
		myCart.add(p1,p2,p3);
		assertEquals(new BigDecimal(29.83).setScale(2, RoundingMode.HALF_UP), myCart.getTotalAmount());
	}
	
	@Test
	public void testCase1TotalTaxes() {
		Product p1 = ProductFactory.getProduct( "Book", new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP) , ProductType.BOOK, LOCAL);
		Product p2 = ProductFactory.getProduct( "music CD", new BigDecimal(14.99).setScale(2, RoundingMode.HALF_UP), ProductType.OTHER, LOCAL); 
		Product p3 = ProductFactory.getProduct( "chocolate bar", new BigDecimal(0.85).setScale(2, RoundingMode.HALF_UP), ProductType.FOOD, LOCAL); 
		
		myCart.add(p1,p2,p3);
		assertEquals(new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP), myCart.getTotalTaxes());
	}
	
	@Test
	public void testCase2TotalAmount() {
		Product p1 = ProductFactory.getProduct( "imported box of chocolates", new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP) , ProductType.FOOD, IMPORTED);
		Product p2 = ProductFactory.getProduct( "imported bottle of perfume", new BigDecimal(47.50).setScale(2, RoundingMode.HALF_UP), ProductType.OTHER, IMPORTED); 
		
		myCart.add(p1,p2);
		assertEquals(new BigDecimal(65.15).setScale(2, RoundingMode.HALF_UP), myCart.getTotalAmount());
	}
	
	@Test
	public void testCase2TotalTaxes() {
		Product p1 = ProductFactory.getProduct( "imported box of chocolates", new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP) , ProductType.FOOD, IMPORTED);
		Product p2 = ProductFactory.getProduct( "imported bottle of perfume", new BigDecimal(47.50).setScale(2, RoundingMode.HALF_UP), ProductType.OTHER, IMPORTED); 
		
		myCart.add(p1,p2);
		assertEquals(new BigDecimal(7.65).setScale(2, RoundingMode.HALF_UP), myCart.getTotalTaxes());
	}
	
	@Test
	public void testCase3TotalAmount() {
		Product p1 = ProductFactory.getProduct( "imported bottle of perfume", new BigDecimal(27.99).setScale(2, RoundingMode.HALF_UP) , ProductType.OTHER, IMPORTED);
		Product p2 = ProductFactory.getProduct( "bottle of perfume", new BigDecimal(18.99).setScale(2, RoundingMode.HALF_UP) , ProductType.OTHER, LOCAL);
		Product p3 = ProductFactory.getProduct( "packet of headache pills", new BigDecimal(9.75).setScale(2, RoundingMode.HALF_UP), ProductType.MEDICINE, LOCAL); 
		Product p4 = ProductFactory.getProduct( "box of imported chocolates ", new BigDecimal(11.25).setScale(2, RoundingMode.HALF_UP), ProductType.FOOD, IMPORTED);
		
		myCart.add(p1,p2,p3,p4);
		assertEquals(new BigDecimal(74.68).setScale(2, RoundingMode.HALF_UP), myCart.getTotalAmount());
	}
	
	@Test
	public void testCase3TotalTaxes() {
		Product p1 = ProductFactory.getProduct( "imported bottle of perfume", new BigDecimal(27.99).setScale(2, RoundingMode.HALF_UP) , ProductType.OTHER, IMPORTED);
		Product p2 = ProductFactory.getProduct( "bottle of perfume", new BigDecimal(18.99).setScale(2, RoundingMode.HALF_UP) , ProductType.OTHER, LOCAL);
		Product p3 = ProductFactory.getProduct( "packet of headache pills", new BigDecimal(9.75).setScale(2, RoundingMode.HALF_UP), ProductType.MEDICINE, LOCAL); 
		Product p4 = ProductFactory.getProduct( "box of imported chocolates ", new BigDecimal(11.25).setScale(2, RoundingMode.HALF_UP), ProductType.FOOD, IMPORTED);
		
		myCart.add(p1,p2,p3,p4);
		assertEquals(new BigDecimal(6.70).setScale(2, RoundingMode.HALF_UP), myCart.getTotalTaxes());
	}
	
	@Test
	public void testQunatity() {
		Product p1 = ProductFactory.getProduct( "imported bottle of perfume", new BigDecimal(27.99).setScale(2, RoundingMode.HALF_UP) , ProductType.OTHER, IMPORTED);
		Product p2 = ProductFactory.getProduct( "imported bottle of perfume", new BigDecimal(27.99).setScale(2, RoundingMode.HALF_UP) , ProductType.OTHER, IMPORTED);
		Product p3 = ProductFactory.getProduct( "packet of headache pills", new BigDecimal(9.75).setScale(2, RoundingMode.HALF_UP), ProductType.MEDICINE, LOCAL); 
		Product p4 = ProductFactory.getProduct( "box of imported chocolates ", new BigDecimal(11.25).setScale(2, RoundingMode.HALF_UP), ProductType.FOOD, IMPORTED);
		
		myCart.add(p1,p2,p3,p4);
		/*
		 * P1 and P2 generate the same hascode() and they are equal because of equals() method overriding
		 */
		assertEquals(new Integer(2), myCart.getProducts().get(p1));
		assertEquals(new Integer(2), myCart.getProducts().get(p2));
	}

}
