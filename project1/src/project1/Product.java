package project1;

public class Product {
    private String _name;
    private double _weight;
    private double _price;

    public Product(String name, double weight, double price)
    {
        _name=name;
        _weight=weight;
        _price=price;
    }

    public String getName()
    {
        return _name;
    }

    public double getWeight()
    {
        return _weight;
    }

    public double getPrice()
    {
        return _price;
    }
}
