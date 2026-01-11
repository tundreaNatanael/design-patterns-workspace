// PATTERN: factory method
package project1;

public class AmazonStock extends Stock {
	public AmazonStock(String currency, double price, int qty) {
		super("Amazon", "AMZ", currency, price, qty, false);
	}
}
