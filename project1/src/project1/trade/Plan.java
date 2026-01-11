// PATTERN: strategy
package project1.trade;

import java.time.LocalDateTime;

import project1.Stock;
import project1.core.Hub;
import project1.model.Holding;
import project1.model.User;

public interface Plan {
	void onBuy(User user, Holding lot, Stock item, LocalDateTime now);

	void onSell(User user, Stock item, int qty, LocalDateTime now);

	void onTick(User user, LocalDateTime now, Hub hub);
}
