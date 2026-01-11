// PATTERN: observer
package project1.notify;

import project1.Stock;

public class Watch implements IPriceListener {
	private double _last;
	private boolean _hasLast;

	public Watch() {
	}

	@Override
	public void update(Stock item, double oldPrice, double newPrice) {
		double prev = oldPrice;
		if (_hasLast)
			prev = _last;
		_last = newPrice;
		_hasLast = true;
		String dir = "up";
		if (newPrice < prev)
			dir = "down";
		System.out.println("watch " + item.getTicker() + " " + dir);
	}
}
