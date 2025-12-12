package project1;

public class PrivateInvestor implements IInvestor {
	private String _investorName;

	public PrivateInvestor(String investorName, StockSubscriber stock) {
		_investorName = investorName;
		stock.subscribe(this);
	}

	@Override
	public void update(Stock newStock) {
		System.out.println(_investorName + " has been notified that the stock " + newStock.getName()
				+ " price has changed: NEW " + newStock.getCurrency() + newStock.getPrice());
	}
}
