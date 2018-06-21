package main;

import java.math.BigDecimal;
import java.math.RoundingMode;

import order.Bill;
import order.ShoppingCart;
import product.Product;
import product.ProductFactory;
import product.ProductType;

public class Main {
	
	final static boolean IMPORTED = true; 
	final static boolean LOCAL = false; 

	public static void main(String[] args) {		
		testCase1();
		testCase2();
		testCase3();	
	}
	
	private static void testCase1(){
		Product p1 = ProductFactory.getProduct( "Book", new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP) , ProductType.BOOK, LOCAL);
		Product p2 = ProductFactory.getProduct( "music CD", new BigDecimal(14.99).setScale(2, RoundingMode.HALF_UP), ProductType.OTHER, LOCAL); 
		Product p3 = ProductFactory.getProduct( "chocolate bar", new BigDecimal(0.85).setScale(2, RoundingMode.HALF_UP), ProductType.FOOD, LOCAL); 

		
		ShoppingCart myCart = new ShoppingCart(); 
		myCart.add(p1,p2,p3);
		Bill myBill = new Bill(myCart); 
		myBill.printTXTBill();
	}
	
	private static void testCase2(){
		Product p1 = ProductFactory.getProduct( "imported box of chocolates", new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP) , ProductType.FOOD, IMPORTED);
		Product p2 = ProductFactory.getProduct( "imported bottle of perfume", new BigDecimal(47.50).setScale(2, RoundingMode.HALF_UP), ProductType.OTHER, IMPORTED); 
		
		ShoppingCart myCart = new ShoppingCart(); 
		myCart.add(p1,p2);
		Bill myBill = new Bill(myCart); 
		myBill.printTXTBill();
	}
	
	private static void testCase3(){
		Product p1 = ProductFactory.getProduct( "imported bottle of perfume", new BigDecimal(27.99).setScale(2, RoundingMode.HALF_UP) , ProductType.OTHER, IMPORTED);
		Product p2 = ProductFactory.getProduct( "bottle of perfume", new BigDecimal(18.99).setScale(2, RoundingMode.HALF_UP) , ProductType.OTHER, LOCAL);
		Product p3 = ProductFactory.getProduct( "packet of headache pills", new BigDecimal(9.75).setScale(2, RoundingMode.HALF_UP), ProductType.MEDICINE, LOCAL); 
		Product p4 = ProductFactory.getProduct( "box of imported chocolates ", new BigDecimal(11.25).setScale(2, RoundingMode.HALF_UP), ProductType.FOOD, IMPORTED); 

		
		ShoppingCart myCart = new ShoppingCart(); 
		myCart.add(p1,p2,p3,p4);
		Bill myBill = new Bill(myCart); 
		myBill.printTXTBill();
	}
	
	

}
