import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import bill.Bill;
import cart.ShoppingCart;
import product.Product;
import product.ProductFactory;
import product.ProductType;

public class Test1 {

	final static boolean IMPORTED = true; 
	final static boolean LOCAL = false; 
	
	public static void main(String[] args) {
		
		
		
		Product p1 = ProductFactory.getProduct( "Book", new BigDecimal(12.49).setScale(2, RoundingMode.HALF_EVEN) , ProductType.BOOK, LOCAL);
		Product p3 = ProductFactory.getProduct( "music CD", new BigDecimal(14.99).setScale(2, RoundingMode.HALF_EVEN), ProductType.OTHER, LOCAL); 
		Product p5 = ProductFactory.getProduct( "chocolate bar", new BigDecimal(0.85).setScale(2, RoundingMode.HALF_EVEN), ProductType.FOOD, LOCAL); 
		
		System.out.println(p1);
		System.out.println(p3);
		System.out.println(p5);
		
		ShoppingCart myCart = new ShoppingCart(); 
		myCart.add(p1,p3,p5);
		Bill myBill = new Bill(myCart); 
		
		 String prefix = "foobar";
		    String suffix = ".txt";
		   		    // shut down
		    File tempFile2;
			try {
				
				tempFile2 = File.createTempFile(prefix, suffix);
				Runtime runtime = Runtime.getRuntime();
				Process process = runtime.exec("notepad "+tempFile2.getCanonicalFile());
		    System.out.format("Canonical filename: %s\n", tempFile2.getCanonicalFile());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
