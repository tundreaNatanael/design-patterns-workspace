// PATTERN: observer
package project1.notify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project1.Stock;

public class WatchCenter {
	private Map<String, List<IPriceListener>> _list = new HashMap<>();

	public void add(String ticker, IPriceListener listener) {
		if (ticker == null || listener == null)
			return;
		if (!_list.containsKey(ticker))
			_list.put(ticker, new ArrayList<>());
		_list.get(ticker).add(listener);
	}

	public void notify(Stock item, double oldPrice, double newPrice) {
		List<IPriceListener> items = _list.get(item.getTicker());
		if (items == null)
			return;
		for (IPriceListener li : items)
			li.update(item, oldPrice, newPrice);
	}
}
