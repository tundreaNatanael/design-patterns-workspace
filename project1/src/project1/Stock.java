// PATTERN: observer
package project1;

import java.util.ArrayList;
import java.util.List;

public abstract class Stock implements StockSubscriber {
	private String _currency;
	private double _price;
	private String _name;
	private String _ticker;
	private int _qty;
	private boolean _isCrypto;
	private List<IInvestor> _investors = new ArrayList<>();

	protected Stock(String name, String ticker, String currency, double price, int qty, boolean isCrypto) {
		_name = name;
		_ticker = ticker;
		_currency = currency;
		_price = price;
		_qty = qty;
		_isCrypto = isCrypto;
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
		_investors.forEach(investor -> investor.update(this));
	}

	public String getName() {
		return _name;
	}

	public void setName(String _name) {
		this._name = _name;
	}

	public String getTicker() {
		return _ticker;
	}

	public void setTicker(String _ticker) {
		this._ticker = _ticker;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double _price) {
		this._price = _price;
		sendNotification();
	}

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String _currency) {
		this._currency = _currency;
		sendNotification();
	}

	public int getQty() {
		return _qty;
	}

	public void setQty(int _qty) {
		this._qty = _qty;
	}

	public boolean isCrypto() {
		return _isCrypto;
	}

	public String getStockInfo() {
		return _ticker + " " + _price + _currency;
	}
}
