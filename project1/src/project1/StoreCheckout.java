package project1;

public class StoreCheckout {
    private Order _order;
    private IShippingCostCalculator _shippingCalculator;

    public StoreCheckout(Order order)
    {
        _order = order;
    }

    public void setShippingCalculator(IShippingCostCalculator shippingCalculator)
    {
        _shippingCalculator = shippingCalculator;
    }

    public double getTotalCost()
    {
        double totalCost = 0;
        for(Product product: _order.getProducts())
        {
            totalCost+=product.getPrice();
        }

        totalCost+=_shippingCalculator.getShippingCost(_order);

        return totalCost;
    }
}
