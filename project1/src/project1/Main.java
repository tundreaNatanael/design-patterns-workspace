package project1;

public class Main {

	public static void main(String[] args) {
		Product product1 = new Product("Laptop", 2, 2400);
		Product product2 = new Product("IPhone 15", 0.500, 6000);
		Product product3 = new Product("frigider", 5, 1200);

		Order order = new Order();
		order.addProduct(product1);
		order.addProduct(product2);
		order.addProduct(product3);

		IShippingCostCalculator fanCurier = new FanCurierCostCalculator();
		IShippingCostCalculator sameDay = new SameDayCostCalculator();

		StoreCheckout checkout = new StoreCheckout(order);
		checkout.setShippingCalculator(fanCurier);

		System.out.println(checkout.getTotalCost());
	}

}
