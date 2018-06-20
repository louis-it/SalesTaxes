package cart;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

import product.Product;

public class ShoppingCart {
	
	LinkedHashMap<Product, Integer> products; 
	BigDecimal totalAmount; 
	BigDecimal totalTaxes; 
	
	public ShoppingCart(){
		products = new LinkedHashMap<>(); 
		totalAmount = BigDecimal.ZERO; 
		totalTaxes = BigDecimal.ZERO; 
	}
	
	public void add(Product p){
		Integer quantity = products.get(p); 
		totalAmount = totalAmount.add(p.getGrossAmount()); 
		totalTaxes = totalTaxes.add(p.getTaxes()); 
		
		if(quantity!=null)
			products.replace(p, ++quantity);
		else 
			products.put(p, 1); 
	}
	
	public void add(Product... pList){
		for(Product p : pList)
			add(p);
	}
	
	public boolean isEmpty(){
		return products.isEmpty(); 
	}

	public LinkedHashMap<Product, Integer> getProducts() {
		return products;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public BigDecimal getTotalTaxes() {
		return totalTaxes;
	}
	
	

}
