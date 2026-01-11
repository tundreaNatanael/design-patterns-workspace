// PATTERN: strategy
package project1.trade;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import project1.Stock;
import project1.core.Hub;
import project1.model.Holding;
import project1.model.User;

public class PlanAuto implements Plan {
	private Map<String, double[]> _levels = new HashMap<>();

	public void set(String ticker, double low, double high) {
		_levels.put(ticker, new double[] { low, high });
	}

	@Override
	public void onBuy(User user, Holding lot, Stock item, LocalDateTime now) {
		lot.setDay(false);
	}

	@Override
	public void onSell(User user, Stock item, int qty, LocalDateTime now) {
	}

	@Override
	public void onTick(User user, LocalDateTime now, Hub hub) {
		for (String ticker : _levels.keySet()) {
			double[] lv = _levels.get(ticker);
			Stock item = hub.search(ticker);
			if (item == null)
				continue;
			if (item.getPrice() < lv[0])
				hub.buy(user, ticker, 1, now);
			if (item.getPrice() > lv[1])
				hub.sell(user, ticker, 1, now);
		}
	}
}
