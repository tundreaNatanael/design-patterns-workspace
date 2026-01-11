// PATTERN: mediator
package project1.core;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project1.Stock;
import project1.model.Holding;
import project1.model.Tx;
import project1.model.User;
import project1.notify.IPriceListener;
import project1.notify.WatchCenter;
import project1.trade.BaseCost;
import project1.trade.BuyAct;
import project1.trade.Cost;
import project1.trade.PenaltyWrap;
import project1.trade.Plan;
import project1.trade.SellAct;

public class Hub {
	private Store _store;
	private WatchCenter _watch = new WatchCenter();
	private Map<String, User> _users = new HashMap<>();
	private BuyAct _buy;
	private SellAct _sell;
	private Cost _penalty = new PenaltyWrap(new BaseCost());
	private boolean _up;

	public Hub(Store store) {
		_store = store;
		_buy = new BuyAct(this, new BaseCost());
		_sell = new SellAct(this, new BaseCost());
		_up = true;
	}

	public boolean register(String user, String pass) {
		if (user == null || pass == null)
			return false;
		if (_users.containsKey(user))
			return false;
		_users.put(user, new User(user, pass));
		return true;
	}

	public User login(String user, String pass) {
		User found = _users.get(user);
		if (found == null)
			return null;
		if (!found.getPass().equals(pass))
			return null;
		return found;
	}

	public void setPlan(User user, Plan plan) {
		if (user == null)
			return;
		user.setPlan(plan);
	}

	public Stock search(String text) {
		if (text == null)
			return null;
		for (Stock item : _store.getItems()) {
			if (text.equalsIgnoreCase(item.getTicker()))
				return item;
			if (text.equalsIgnoreCase(item.getName()))
				return item;
		}
		return null;
	}

	public void buy(User user, String ticker, int qty, LocalDateTime now) {
		Stock item = _store.getItem(ticker);
		_buy.execute(user, item, qty, now);
	}

	public void sell(User user, String ticker, int qty, LocalDateTime now) {
		Stock item = _store.getItem(ticker);
		_sell.execute(user, item, qty, now);
	}

	public void watch(User user, String ticker, IPriceListener listener) {
		if (user == null || listener == null)
			return;
		Stock item = _store.getItem(ticker);
		if (item == null)
			return;
		user.addWatch(ticker);
		_watch.add(ticker, listener);
	}

	public void tick(LocalDateTime now) {
		_up = !_up;
		for (Stock item : _store.getItems()) {
			double oldPrice = item.getPrice();
			double delta = _up ? 1 : -1;
			double newPrice = oldPrice + delta;
			item.setPrice(newPrice);
			_watch.notify(item, oldPrice, newPrice);
		}
		for (User user : _users.values()) {
			applyDayFees(user, now);
			Plan plan = user.getPlan();
			if (plan != null)
				plan.onTick(user, now, this);
		}
	}

	private void applyDayFees(User user, LocalDateTime now) {
		for (Holding h : user.getPortfolio().getHoldings()) {
			if (!h.isDay() || h.isCharged())
				continue;
			Stock item = _store.getItem(h.getTicker());
			if (item == null || item.isCrypto())
				continue;
			if (!now.toLocalDate().isAfter(h.getBuyDate()))
				continue;
			double value = item.getPrice() * h.getQty();
			double fee = _penalty.calc(value) - value;
			if (fee <= 0)
				continue;
			user.addCash(-fee);
			h.setCharged(true);
			System.out.println("fee");
		}
	}

	public boolean canTrade(Stock item, LocalDateTime now) {
		if (item == null || now == null)
			return false;
		if (item.isCrypto())
			return true;
		DayOfWeek day = now.getDayOfWeek();
		if (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY) {
			System.out.println("closed");
			return false;
		}
		int hour = now.getHour();
		if (hour < 9 || hour >= 18) {
			System.out.println("closed");
			return false;
		}
		return true;
	}

	public List<Tx> history(User user) {
		if (user == null)
			return new ArrayList<>();
		return user.getHistory();
	}
}
