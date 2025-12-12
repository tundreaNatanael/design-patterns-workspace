package project1;

public class PrivateInvestor implements IInvestor {
	private String _investorName;

	public PrivateInvestor(String investorName, StockSubscriber stock) {
		_investorName = investorName;
		stock.subscribe(this);
	}

	@Override
	public void update() {
		System.out.println(_investorName + " has been notified that the stock price has changed");
	}
}
