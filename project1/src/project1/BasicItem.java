// PATTERN: factory method
package project1;

public class BasicItem extends Stock {
	public BasicItem(String name, String ticker, String currency, double price, int qty, boolean isCrypto) {
		super(name, ticker, currency, price, qty, isCrypto);
	}
}
