package project1;

public class SameDayCostCalculator implements IShippingCostCalculator{
    private double BasePrice = 15;
    private double MaxFreeWeight = 10;
    private double PricePerKg = 5;


    @Override
    public double getShippingCost(Order order) {
        var totalWeight = 0;
        for(Product product: order.getProducts())
        {
            totalWeight+=product.getWeight();
        }

        var totalCost = BasePrice;
        if (totalWeight > MaxFreeWeight)
        {
            totalCost += (totalWeight - MaxFreeWeight) * PricePerKg;
        }

        return totalCost;
    }
}
