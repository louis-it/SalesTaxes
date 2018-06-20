package bill;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

	public void printTXTBill(){

		Map<Product, Integer> products = cart.getProducts(); 
		Set<Product> keySet = products.keySet(); 
				
		String prefix = "receipt";
		String suffix = ".txt";
		File tempFile;
		BufferedWriter bw = null; 
		try {				
			tempFile = File.createTempFile(prefix, suffix);
			bw = new BufferedWriter(new FileWriter(tempFile)); 
			print(bw,"----------------------------------------");
			
			for(Product p:keySet){
				print(bw,products.get(p)+" " +p.getDescription()+" at "+(p.getGrossAmount()));
			}
			
			print(bw, "Sales Taxes: "+cart.getTotalTaxes());
			print(bw,"Total: "+cart.getTotalAmount());
			print(bw,"----------------------------------------");
			
			Runtime runtime = Runtime.getRuntime();
			runtime.exec("notepad "+tempFile.getCanonicalFile());
			System.out.format("Canonical filename: %s\n", tempFile.getCanonicalFile());

		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(bw!=null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
	
	private void print(BufferedWriter bw, String s) throws IOException{
		bw.write(s); 
		bw.write("\r\n"); 
	}



}
