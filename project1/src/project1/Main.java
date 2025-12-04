package project1;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Mediator mediator = new Mediator();

		System.out.println("🚗 BOLT APP SIMULATION 🛴");
		System.out.println("========================\n");

		// Register vehicles at various locations
		mediator.registerVehicle(new Car("C001", 100));
		mediator.registerVehicle(new Car("C002", 40));
		mediator.registerVehicle(new Car("C003", 55));
		mediator.registerVehicle(new Car("C004", 80));

		mediator.registerVehicle(new Scooter("S001", 30, 15)); // Can go 15 km
		mediator.registerVehicle(new Scooter("S002", 35, 5)); // Can go 5 km (low battery)
		mediator.registerVehicle(new Scooter("S003", 45, 25)); // Can go 25 km
		mediator.registerVehicle(new Scooter("S004", 20, 8)); // Can go 8 km

		// Scenario 1: Client at location 30, wants to travel 10 km
		System.out.println("\n\n" + "=".repeat(60));
		System.out.println("SCENARIO 1: Short trip");
		System.out.println("=".repeat(60));

		Client john = new Client("John", 30);
		List<Vehicle> options1 = mediator.findAvailableVehicles(john, 10);

		if (!options1.isEmpty()) {
			Vehicle selected = options1.get(0);
			mediator.bookVehicle(selected);
		}

		// Scenario 2: Client at location 50, wants to travel 20 km
		System.out.println("\n\n" + "=".repeat(60));
		System.out.println("SCENARIO 2: Medium trip with scooter filtering");
		System.out.println("=".repeat(60));

		Client sarah = new Client("Sarah", 50);
		List<Vehicle> options2 = mediator.findAvailableVehicles(sarah, 20);

		if (!options2.isEmpty()) {
			Vehicle selected = options2.get(1); // Select second option
			mediator.bookVehicle(selected);
		}

		// Scenario 3: Client at location 75, wants to travel 8 km
		System.out.println("\n\n" + "=".repeat(60));
		System.out.println("SCENARIO 3: Another client - some vehicles in use");
		System.out.println("=".repeat(60));

		Client mike = new Client("Mike", 75);
		List<Vehicle> options3 = mediator.findAvailableVehicles(mike, 8);

		// Show current system status
		((Mediator) mediator).displayAllVehicles();

		// Scenario 4: Release a vehicle and search again
		System.out.println("\n\n" + "=".repeat(60));
		System.out.println("SCENARIO 4: Releasing vehicle and searching again");
		System.out.println("=".repeat(60));

		if (!options1.isEmpty()) {
			mediator.releaseVehicle(options1.get(0));
		}

		Client emma = new Client("Emma", 28);
		mediator.findAvailableVehicles(emma, 12);

		// Demonstrate scooter 50% rule
		System.out.println("\n\n" + "=".repeat(60));
		System.out.println("SCENARIO 5: Long trip - scooters with low charge excluded");
		System.out.println("=".repeat(60));

		Client alex = new Client("Alex", 32);
		mediator.findAvailableVehicles(alex, 16);

		System.out.println("\n\n✅ Demo completed!");
		System.out.println("\nKey Features Demonstrated:");
		System.out.println("• Mediator pattern coordinates all vehicle-client interactions");
		System.out.println("• Returns 3 closest available vehicles");
		System.out.println("• Scooters excluded if range < 50% of trip distance");
		System.out.println("• Vehicles in trip are not shown as options");
		System.out.println("• Distance calculation based on straight-line axis (1-100 km)");

	}

}
