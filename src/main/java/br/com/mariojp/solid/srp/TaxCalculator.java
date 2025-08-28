package br.com.mariojp.solid.srp;

public class TaxService {
	private final double taxRate;
	
	public TaxService() {
		
		String rate = System.getProperty("tax.rate", "0.10");
		this.taxRate = Double.parseDouble(rate);
	}

	public double calculate(double subtotal) {
		return subtotal * taxRate;
	}
}