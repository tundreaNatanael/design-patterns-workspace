// PATTERN: template method
package project1.trade;

import java.time.LocalDateTime;

import project1.Stock;
import project1.core.Hub;
import project1.model.Tx;
import project1.model.User;

public abstract class Steps {
	private Hub _hub;
	private Cost _cost;

	protected Steps(Hub hub, Cost cost) {
		_hub = hub;
		_cost = cost;
	}

	public void run(User user, Stock item, int qty, LocalDateTime now) {
		if (user == null || item == null)
			return;
		if (qty <= 0)
			return;
		if (!_hub.canTrade(item, now))
			return;
		double base = item.getPrice() * qty;
		double total = _cost.calc(base);
		if (!check(user, item, qty, total)) {
			fail();
			return;
		}
		apply(user, item, qty, total, now);
		record(user, item, qty, now);
	}

	protected abstract boolean check(User user, Stock item, int qty, double total);

	protected abstract void apply(User user, Stock item, int qty, double total, LocalDateTime now);

	protected abstract void fail();

	protected void record(User user, Stock item, int qty, LocalDateTime now) {
		user.addTx(new Tx(tag(), item.getTicker(), item.getName(), qty, item.getPrice(), now));
	}

	protected abstract String tag();
}
