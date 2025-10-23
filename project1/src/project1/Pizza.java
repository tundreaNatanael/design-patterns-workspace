package project1;

public class Pizza {
    private String size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;
    
    // Constructor privat - doar Builder-ul poate crea Pizza
    Pizza(PizzaBuilder builder) {
        this.size = builder.getSize();
        this.cheese = builder.isCheese();
        this.pepperoni = builder.isPepperoni();
        this.mushrooms = builder.isMushrooms();
    }
    
    @Override
    public String toString() {
        return "Pizza " + size + 
               (cheese ? " cu brânză" : "") +
               (pepperoni ? " cu pepperoni" : "") +
               (mushrooms ? " cu ciuperci" : "");
    }
    
}
