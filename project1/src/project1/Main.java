package project1;

public class Main {

	public static void main(String[] args) {
		
		// factory method
		ClassicArtist beethoven = new ClassicArtist();
		beethoven.singSong();
		
		RockArtist queen = new RockArtist();
		queen.singSong();
		
		// builder method
		Pizza pizzaSimple = new PizzaBuilder("mare").withCheese().withPepperoni().build();
		
		System.out.println(pizzaSimple.toString());
		
		// abstract method
		System.out.println("\nModern Furniture:");
		FurnitureFactory modernFactory = new ModernFurnitureFactory();
        Chair modernChair = modernFactory.createChair();
        Table modernTable = modernFactory.createTable();
        modernChair.sitOn();
        modernTable.putStuffOn();
        
        System.out.println("\nClassic Furniture:");
        FurnitureFactory classicFactory = new ClassicFurnitureFactory();
        Chair classicChair = classicFactory.createChair();
        Table classicTable = classicFactory.createTable();
        classicChair.sitOn();
        classicTable.putStuffOn();
		
	}
	

}
