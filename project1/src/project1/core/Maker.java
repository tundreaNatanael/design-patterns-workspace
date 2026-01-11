// PATTERN: factory method
package project1.core;

import project1.AmazonStock;
import project1.BasicItem;
import project1.Stock;

public class Maker {
	public Stock make(String name, String ticker, String currency, double price, int qty, boolean isCrypto) {
		if ("AMZ".equals(ticker))
			return new AmazonStock(currency, price, qty);
		return new BasicItem(name, ticker, currency, price, qty, isCrypto);
	}
}
