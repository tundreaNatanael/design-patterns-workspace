package project1;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Mediator mediator = new Mediator();

		System.out.println("RIDE APP\n");

		mediator.registerVehicle(new Car("C001", 100));
		mediator.registerVehicle(new Car("C002", 40));

		mediator.registerVehicle(new Scooter("S001", 30, 15));
		mediator.registerVehicle(new Scooter("S002", 35, 5));

		System.out.println("\n\n" + "=".repeat(60));
		System.out.println("TEST 1: short ride");
		System.out.println("=".repeat(60));

		Client john = new Client("John", 30);
		List<Vehicle> options1 = mediator.findAvailableVehicles(john, 10);

		if (!options1.isEmpty()) {
			Vehicle selected = options1.get(0);
			mediator.bookVehicle(selected);
		}

		System.out.println("\n\n" + "=".repeat(60));
		System.out.println("TEST 2: medium trip");
		System.out.println("=".repeat(60));

		Client sarah = new Client("Sarah", 50);
		List<Vehicle> options2 = mediator.findAvailableVehicles(sarah, 20);

		if (!options2.isEmpty()) {
			Vehicle selected = options2.get(1);
			mediator.bookVehicle(selected);
		}

		System.out.println("\n\n" + "=".repeat(60));
		System.out.println("TEST 3: another customer");
		System.out.println("=".repeat(60));

		Client mike = new Client("Mike", 75);
		List<Vehicle> options3 = mediator.findAvailableVehicles(mike, 8);

		((Mediator) mediator).displayAllVehicles();

		System.out.println("\n\n" + "=".repeat(60));
		System.out.println("TEST 4: finish trip n search again");
		System.out.println("=".repeat(60));

		if (!options1.isEmpty()) {
			mediator.releaseVehicle(options1.get(0));
		}

		Client emma = new Client("Emma", 28);
		mediator.findAvailableVehicles(emma, 12);

		System.out.println("\n\n" + "=".repeat(60));
		System.out.println("TEST 5: long trip");
		System.out.println("=".repeat(60));

		Client alex = new Client("Alex", 32);
		mediator.findAvailableVehicles(alex, 16);

		System.out.println("\n\ndone!");
		System.out.println("\nwhat we showed:");
		System.out.println("- mediator handles all rides");
		System.out.println("- shows 3 closest cars");
		System.out.println("- scooters need 50% battery minimum");
		System.out.println("- busy vehicles not shown");
		System.out.println("- distance is simple calc");

	}

}
