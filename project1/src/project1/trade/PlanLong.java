// PATTERN: strategy
package project1.trade;

import java.time.LocalDateTime;

import project1.Stock;
import project1.core.Hub;
import project1.model.Holding;
import project1.model.User;

public class PlanLong implements Plan {
	@Override
	public void onBuy(User user, Holding lot, Stock item, LocalDateTime now) {
		lot.setDay(false);
	}

	@Override
	public void onSell(User user, Stock item, int qty, LocalDateTime now) {
	}

	@Override
	public void onTick(User user, LocalDateTime now, Hub hub) {
	}
}
