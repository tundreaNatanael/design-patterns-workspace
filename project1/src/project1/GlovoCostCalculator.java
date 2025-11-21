package project1;

public class GlovoCostCalculator implements IShippingCostCalculator {

	private int pricePerKm = 7;

	@Override
	public double getShippingCost(Order order) {
		return order.getDistanceToDestination() * this.pricePerKm;
	}

}
