package project1;

public interface StockSubscriber {
	void subscribe(IInvestor investor);

	void unsubscribe(IInvestor investor);
}
