// PATTERN: command
package project1.trade;

import java.time.LocalDateTime;

import project1.Stock;
import project1.core.Hub;
import project1.model.Holding;
import project1.model.User;

public class BuyAct extends Steps implements Act {
	public BuyAct(Hub hub, Cost cost) {
		super(hub, cost);
	}

	@Override
	public void execute(User user, Stock item, int qty, LocalDateTime now) {
		run(user, item, qty, now);
	}

	@Override
	protected boolean check(User user, Stock item, int qty, double total) {
		if (item.getQty() < qty)
			return false;
		if (user.getCash() < total)
			return false;
		return true;
	}

	@Override
	protected void apply(User user, Stock item, int qty, double total, LocalDateTime now) {
		item.setQty(item.getQty() - qty);
		user.addCash(-total);
		Holding lot = new Holding(item.getTicker(), item.getName(), qty, now.toLocalDate());
		user.getPortfolio().add(lot);
		Plan plan = user.getPlan();
		if (plan != null)
			plan.onBuy(user, lot, item, now);
		System.out.println("buy ok");
	}

	@Override
	protected void fail() {
		System.out.println("buy no");
	}

	@Override
	protected String tag() {
		return "buy";
	}
}
