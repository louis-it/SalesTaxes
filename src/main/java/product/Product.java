package product;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Product {

	
	protected String description; 
	protected BigDecimal netAmount; 
	protected BigDecimal grossAmount; 
	protected BigDecimal taxRate; 
	protected BigDecimal finalTax;
	protected ProductType type; 
	
	public Product(){
		super (); 
	
	}

	public Product( String description, BigDecimal amount, ProductType type) {
		super();
		
		this.description = description;
		this.netAmount = amount;
		this.grossAmount = amount;  
		this.type = type;
		this.taxRate = type.rate(); 
		this.finalTax= BigDecimal.ZERO; 
	}
		

	protected abstract void computeFinalTax();
	protected abstract void computeGrossAmount();


	public String getDescription() {
		return description;
	}

	public BigDecimal getNetAmount() {
		return grossAmount;
	}
	
	public BigDecimal getGrossAmount() {
		return grossAmount;
	}

	public BigDecimal getTaxes() {
		return finalTax;
	}


	public BigDecimal getTaxRate() {
		return taxRate;
	}


	@Override
	public String toString() {
		return "Product [ description=" + description + ", amount=" + netAmount + ", taxes=" + finalTax
				+ ", taxRate=" + taxRate + ", type=" + type + "]";
	}

	@Override
	public boolean equals(Object arg0) {
		if(arg0 == this) return true; 
		
		if(!(arg0 instanceof Product))
			return false; 
		else{
			Product p = (Product)arg0; 
			return (this.description.equals(p.description) && this.netAmount.equals(p.netAmount) && this.grossAmount.equals(p.grossAmount));
		}
			
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, netAmount, taxRate); 
	} 
	
	
	
	
}
