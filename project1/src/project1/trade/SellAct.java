// PATTERN: command
package project1.trade;

import java.time.LocalDateTime;

import project1.Stock;
import project1.core.Hub;
import project1.model.User;

public class SellAct extends Steps implements Act {
	public SellAct(Hub hub, Cost cost) {
		super(hub, cost);
	}

	@Override
	public void execute(User user, Stock item, int qty, LocalDateTime now) {
		run(user, item, qty, now);
	}

	@Override
	protected boolean check(User user, Stock item, int qty, double total) {
		if (user.getQty(item.getTicker()) < qty)
			return false;
		return true;
	}

	@Override
	protected void apply(User user, Stock item, int qty, double total, LocalDateTime now) {
		item.setQty(item.getQty() + qty);
		user.addCash(total);
		user.removeQty(item.getTicker(), qty, now);
		Plan plan = user.getPlan();
		if (plan != null)
			plan.onSell(user, item, qty, now);
		System.out.println("sell ok");
	}

	@Override
	protected void fail() {
		System.out.println("sell no");
	}

	@Override
	protected String tag() {
		return "sell";
	}
}
