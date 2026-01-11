// PATTERN: observer
package project1.notify;

import project1.Stock;

public interface IPriceListener {
	void update(Stock item, double oldPrice, double newPrice);
}
