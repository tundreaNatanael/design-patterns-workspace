package project1;

public class PizzaBuilder {
    String size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;
    
    public PizzaBuilder(String size) {
        this.size = size;
    }

    public PizzaBuilder withCheese() {
        this.cheese = true;
        return this;
    }
    
    public PizzaBuilder withPepperoni() {
        this.pepperoni = true;
        return this;
    }
    
    public PizzaBuilder withMushrooms() {
        this.mushrooms = true;
        return this;
    }
    
    public Pizza build() {
        return new Pizza(this);
    }

	public String getSize() {
		return size;
	}

	public boolean isCheese() {
		return cheese;
	}

	public boolean isPepperoni() {
		return pepperoni;
	}

	public boolean isMushrooms() {
		return mushrooms;
	}
}