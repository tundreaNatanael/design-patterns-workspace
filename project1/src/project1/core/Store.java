// PATTERN: singleton
package project1.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project1.Stock;

public class Store {
	private static Store _inst;
	private Map<String, Stock> _items = new HashMap<>();

	private Store() {
	}

	public static Store get() {
		if (_inst == null)
			_inst = new Store();
		return _inst;
	}

	public void add(Stock item) {
		if (item == null)
			return;
		_items.put(item.getTicker(), item);
	}

	public Stock getItem(String ticker) {
		if (ticker == null)
			return null;
		return _items.get(ticker);
	}

	public List<Stock> getItems() {
		return new ArrayList<>(_items.values());
	}
}
