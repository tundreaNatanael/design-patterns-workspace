// PATTERN: command
package project1.model;

import java.time.LocalDateTime;

public class Tx {
	private String _side;
	private String _ticker;
	private String _name;
	private int _qty;
	private double _price;
	private LocalDateTime _time;

	public Tx(String side, String ticker, String name, int qty, double price, LocalDateTime time) {
		_side = side;
		_ticker = ticker;
		_name = name;
		_qty = qty;
		_price = price;
		_time = time;
	}

	public String getSide() {
		return _side;
	}

	public String getTicker() {
		return _ticker;
	}

	public String getName() {
		return _name;
	}

	public int getQty() {
		return _qty;
	}

	public double getPrice() {
		return _price;
	}

	public LocalDateTime getTime() {
		return _time;
	}
}
