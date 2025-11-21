package project1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> _products=new ArrayList<Product>();
    private double _distanceToDestination = 10;

    public void addProduct(Product product)
    {
        _products.add(product);
    }

    public List<Product> getProducts()
    {
        return _products;
    }

    public double getDistanceToDestination()
    {
        return _distanceToDestination;
    }
}
