package project1;

public class PublicInvestor implements IInvestor {
	private String _investorName;

	public PublicInvestor(String investorName, StockSubscriber stock) {
		_investorName = investorName;
		stock.subscribe(this);
	}

	@Override
	public void update() {
		System.out.println(_investorName + " has been notified that the stock price has changed ");
	}
}
