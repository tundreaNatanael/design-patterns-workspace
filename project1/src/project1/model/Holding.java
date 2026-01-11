// PATTERN: composite
package project1.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import project1.Stock;
import project1.core.Store;

public class Holding implements Node {
	private String _ticker;
	private String _name;
	private int _qty;
	private LocalDate _buyDate;
	private boolean _day;
	private boolean _charged;

	public Holding(String ticker, String name, int qty, LocalDate buyDate) {
		_ticker = ticker;
		_name = name;
		_qty = qty;
		_buyDate = buyDate;
	}

	@Override
	public double totalValue(Store store) {
		Stock item = store.getItem(_ticker);
		if (item == null)
			return 0;
		return item.getPrice() * _qty;
	}

	@Override
	public List<Holding> getHoldings() {
		List<Holding> list = new ArrayList<>();
		list.add(this);
		return list;
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

	public void setQty(int qty) {
		_qty = qty;
	}

	public LocalDate getBuyDate() {
		return _buyDate;
	}

	public boolean isDay() {
		return _day;
	}

	public void setDay(boolean day) {
		_day = day;
	}

	public boolean isCharged() {
		return _charged;
	}

	public void setCharged(boolean charged) {
		_charged = charged;
	}
}
