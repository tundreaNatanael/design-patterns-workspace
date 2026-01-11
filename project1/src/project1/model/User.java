// PATTERN: strategy
package project1.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import project1.trade.Plan;

public class User {
	private String _user;
	private String _pass;
	private double _cash = 10000;
	private Group _portfolio = new Group();
	private List<Tx> _history = new ArrayList<>();
	private List<String> _watch = new ArrayList<>();
	private Plan _plan;

	public User(String user, String pass) {
		_user = user;
		_pass = pass;
	}

	public String getUser() {
		return _user;
	}

	public String getPass() {
		return _pass;
	}

	public double getCash() {
		return _cash;
	}

	public void addCash(double value) {
		_cash += value;
	}

	public Group getPortfolio() {
		return _portfolio;
	}

	public List<Tx> getHistory() {
		return _history;
	}

	public void addTx(Tx tx) {
		if (tx == null)
			return;
		_history.add(tx);
	}

	public void addWatch(String ticker) {
		if (ticker == null)
			return;
		if (_watch.contains(ticker))
			return;
		_watch.add(ticker);
	}

	public List<String> getWatch() {
		return _watch;
	}

	public Plan getPlan() {
		return _plan;
	}

	public void setPlan(Plan plan) {
		_plan = plan;
	}

	public int getQty(String ticker) {
		int sum = 0;
		for (Holding h : _portfolio.getHoldings()) {
			if (ticker.equals(h.getTicker()))
				sum += h.getQty();
		}
		return sum;
	}

	public int removeQty(String ticker, int qty, LocalDateTime now) {
		int left = qty;
		List<Holding> list = _portfolio.getHoldings();
		for (Holding h : list) {
			if (!ticker.equals(h.getTicker()))
				continue;
			if (left <= 0)
				break;
			int take = h.getQty();
			if (take > left)
				take = left;
			h.setQty(h.getQty() - take);
			left -= take;
		}
		List<Holding> all = new ArrayList<>(_portfolio.getHoldings());
		for (Holding h : all) {
			if (h.getQty() == 0)
				_portfolio.remove(h);
		}
		return qty - left;
	}
}
