package project1;

public class FanCurierCostCalculator implements IShippingCostCalculator{
    private double MaxFreeWeight = 5;
    private double ExtraKgCost = 2;
    private double MaxFreeDistance = 200;
    private double ExtraKmCost = 100.566576575;
    private double BasePrice = 14;

    @Override
    public double getShippingCost(Order order) {
        var totalWeight = 0;
        for(Product product: order.getProducts())
        {
            totalWeight+=product.getWeight();
        }

        double totalCost = BasePrice;
        if (totalWeight > MaxFreeWeight)
        {
            totalCost += (totalWeight - MaxFreeWeight) * ExtraKgCost;
        }

        if (order.getDistanceToDestination() > MaxFreeDistance)
        {
            totalCost += (order.getDistanceToDestination() - MaxFreeDistance) * ExtraKmCost;
        }

        return totalCost;
    }
}
