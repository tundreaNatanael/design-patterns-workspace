// PATTERN: facade
package project1.core;

import java.time.LocalDateTime;
import java.util.List;

import project1.Stock;
import project1.model.Tx;
import project1.model.User;
import project1.notify.IPriceListener;
import project1.trade.Plan;

public class Gate {
	private Hub _hub;

	public Gate(Hub hub) {
		_hub = hub;
	}

	public boolean register(String user, String pass) {
		return _hub.register(user, pass);
	}

	public User login(String user, String pass) {
		return _hub.login(user, pass);
	}

	public void setPlan(User user, Plan plan) {
		_hub.setPlan(user, plan);
	}

	public Stock search(String text) {
		return _hub.search(text);
	}

	public void buy(User user, String ticker, int qty, LocalDateTime now) {
		_hub.buy(user, ticker, qty, now);
	}

	public void sell(User user, String ticker, int qty, LocalDateTime now) {
		_hub.sell(user, ticker, qty, now);
	}

	public void tick(LocalDateTime now) {
		_hub.tick(now);
	}

	public void watch(User user, String ticker, IPriceListener listener) {
		_hub.watch(user, ticker, listener);
	}

	public List<Tx> history(User user) {
		return _hub.history(user);
	}
}
