package product;

import java.math.BigDecimal;

public class ProductFactory {
	

	
	public static Product getProduct(String description, BigDecimal amount, ProductType type, boolean imported ){
		if(imported)
			return new ImportedProduct( description, amount, type); 
		else 
			return new LocalProduct( description, amount, type); 
	}

}
