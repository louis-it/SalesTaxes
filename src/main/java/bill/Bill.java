package bill;


import java.util.Map;
import java.util.Set;

import cart.ShoppingCart;
import product.Product;

public class Bill {
	
	ShoppingCart cart;
	
	public Bill(ShoppingCart cart){
		this.cart = cart; 
		printBill();

	}


	public void printBill(){
		System.out.println("----------------------------------------");
		Map<Product, Integer> products = cart.getProducts(); 
		Set<Product> keySet = products.keySet(); 
		for(Product p:keySet){
			System.out.println(products.get(p)+" " +p.getDescription()+" at "+(p.getGrossAmount()));
		}
		System.out.println("Sales Taxes: "+cart.getTotalTaxes());
		System.out.println("Total: "+cart.getTotalAmount());
		System.out.println("----------------------------------------");

	}
	


}
