package br.com.mariojp.solid.srp;

public class ReceiptService {
	
	private final TaxService taxService = new TaxService();
	private final ReceiptFormatter formatter = new ReceiptFormatter();
	
	public String generate(Order order) {
		double subtotal = order.getItems().stream().mapToDouble(i -> i.getUnitPrice() * i.getQuantity()).sum();
		
		
		double tax = taxService.calculate(subtotal);
		double total = subtotal + tax;
	
		return formatter.format(order, subtotal, tax, total);
	}	
}