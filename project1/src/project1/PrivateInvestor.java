// PATTERN: observer
package project1;

public class PrivateInvestor implements IInvestor {
	private String _investorName;
	private double _lastPrice;
	private boolean _hasLast;

	public PrivateInvestor(String investorName, StockSubscriber stock) {
		_investorName = investorName;
		stock.subscribe(this);
	}

	@Override
	public void update(Stock newStock) {
		String dir = "up";
		if (_hasLast && newStock.getPrice() < _lastPrice)
			dir = "down";
		_lastPrice = newStock.getPrice();
		_hasLast = true;
		System.out.println(_investorName + " watch " + newStock.getTicker() + " " + dir);
	}
}
