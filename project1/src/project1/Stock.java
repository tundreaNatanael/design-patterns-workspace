package project1;

import java.util.ArrayList;
import java.util.List;

public abstract class Stock implements StockSubscriber {
	private String _currency;
	private double _price;
	private String _name;
	private List<IInvestor> _investors = new ArrayList<>();

	protected Stock(String name, String currency, double price) {
		_name = name;
		_currency = currency;
		_price = price;
	}

	public void subscribe(IInvestor investor) {
		if (_investors.contains(investor))
			return;
		_investors.add(investor);
	}

	public void unsubscribe(IInvestor investor) {
		if (!_investors.contains(investor))
			return;
		_investors.remove(investor);
	}

	private void sendNotification() {
		_investors.forEach(IInvestor::update);
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public double get_price() {
		return _price;
	}

	public void set_price(double _price) {
		this._price = _price;
		// each time the price changes, it will sendNotification its observers
		sendNotification();
	}

	public String get_currency() {
		return _currency;
	}

	public void set_currency(String _currency) {
		this._currency = _currency;
		// each time the currency changes, it will sendNotification its observers
		sendNotification();
	}

	public String getStockInfo() {
		return _name + " " + _price + _currency;
	}
}
