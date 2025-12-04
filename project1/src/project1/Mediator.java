package project1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Mediator {
	private List<Vehicle> vehicles;

	public Mediator() {
		this.vehicles = new ArrayList<>();
	}

	public void registerVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
		System.out.println("Registered: " + vehicle.getVehicleInfo());
	}

	public List<Vehicle> findAvailableVehicles(Client client, int tripDistance) {
		System.out.println("\n=== Finding vehicles for " + client.getName() + " ===");
		System.out.println("Client location: " + client.getLocation() + " km");
		System.out.println("Trip distance: " + tripDistance + " km");

		// Calculate distances from client and filter available vehicles
		List<Vehicle> availableVehicles = vehicles.stream().filter(v -> !v.isInTrip()) // Not in another trip
				.peek(v -> {
					// Update distance from client based on client's location
					int distance = Math.abs(v.getDistanceFromClient() - client.getLocation());
					v.setDistanceFromClient(distance);
				}).filter(v -> v.canCompleteTrip(tripDistance)) // Can complete at least 50% for scooters
				.sorted(Comparator.comparingInt(Vehicle::getDistanceFromClient)) // Sort by distance
				.limit(3) // Get top 3 closest
				.collect(Collectors.toList());

		System.out.println("\nFound " + availableVehicles.size() + " available options:");
		for (int i = 0; i < availableVehicles.size(); i++) {
			Vehicle v = availableVehicles.get(i);
			System.out.println((i + 1) + ". " + v.getVehicleInfo());

			// Show trip estimate for scooters
			if (v instanceof Scooter) {
				Scooter scooter = (Scooter) v;
				System.out.println("   → " + scooter.getTripEstimate(tripDistance));
			}
		}

		return availableVehicles;
	}

	public void bookVehicle(Vehicle vehicle) {
		vehicle.setInTrip(true);
		System.out.println("\n✓ Booked: " + vehicle.getVehicleInfo());
	}

	public void releaseVehicle(Vehicle vehicle) {
		vehicle.setInTrip(false);
		System.out.println("✓ Released: " + vehicle.getVehicleInfo());
	}

	public void displayAllVehicles() {
		System.out.println("\n=== All Vehicles in System ===");
		for (Vehicle v : vehicles) {
			String status = v.isInTrip() ? "[IN TRIP]" : "[AVAILABLE]";
			System.out.println(status + " " + v.getVehicleInfo());
		}
	}
}
