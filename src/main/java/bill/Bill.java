package bill;


import java.awt.Desktop;
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
		File tempFile = null;
		BufferedWriter bw = null; 
		try {				
			tempFile = File.createTempFile(prefix, suffix);
			bw = new BufferedWriter(new FileWriter(tempFile.getCanonicalFile())); 
			print(bw,"----------------------------------------");
			
			for(Product p:keySet){
				print(bw,products.get(p)+" " +p.getDescription()+" at "+(p.getGrossAmount()));
			}
			
			print(bw, "Sales Taxes: "+cart.getTotalTaxes());
			print(bw,"Total: "+cart.getTotalAmount());
			print(bw,"----------------------------------------");
			
			
			System.out.format("Canonical filename: %s\n", tempFile.getCanonicalFile());

		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(bw!=null)
					bw.close();
				/*
				 * The File opening process with Notepad had some issues 
				 * 	when called before Buffered Writer closure.
				 */
				open(tempFile); 
				
			} catch (IOException e) {
				e.printStackTrace();
			}


		}
	}
	
	private void print(BufferedWriter bw, String s) throws IOException{
		bw.write(s);
		bw.write("\r\n"); 
	}
	
	public static boolean open(File file)
	{
	    try
	    {
	        if (OSDetector.isWindows())
	        {
	            Runtime.getRuntime().exec(new String[]
	            {"rundll32", "url.dll,FileProtocolHandler",
	             file.getAbsolutePath()});
	            return true;
	        } else if (OSDetector.isLinux() || OSDetector.isMac())
	        {
	            Runtime.getRuntime().exec(new String[]{"/usr/bin/open",
	                                                   file.getAbsolutePath()});
	            return true;
	        } else
	        {
	            // Unknown OS, try with desktop
	            if (Desktop.isDesktopSupported())
	            {
	                Desktop.getDesktop().open(file);
	                return true;
	            }
	            else
	            {
	                return false;
	            }
	        }
	    } catch (Exception e)
	    {
	        e.printStackTrace(System.err);
	        return false;
	    }
	}
	
	private static class OSDetector
	{
	    private static boolean isWindows = false;
	    private static boolean isLinux = false;
	    private static boolean isMac = false;

	    static
	    {
	        String os = System.getProperty("os.name").toLowerCase();
	        isWindows = os.contains("win");
	        isLinux = os.contains("nux") || os.contains("nix");
	        isMac = os.contains("mac");
	    }

	    public static boolean isWindows() { return isWindows; }
	    public static boolean isLinux() { return isLinux; }
	    public static boolean isMac() { return isMac; };

	}



}
