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
		System.out.println("added: " + vehicle.getVehicleInfo());
	}

	public List<Vehicle> findAvailableVehicles(Client client, int tripDistance) {
		System.out.println("\n=== searchin rides for " + client.getName() + " ===");
		System.out.println("ur at: " + client.getLocation() + " km");
		System.out.println("trip: " + tripDistance + " km");

		List<Vehicle> availableVehicles = vehicles.stream().filter(v -> !v.isInTrip())
				.peek(v -> {
					int distance = Math.abs(v.getDistanceFromClient() - client.getLocation());
					v.setDistanceFromClient(distance);
				}).filter(v -> v.canCompleteTrip(tripDistance))
				.sorted(Comparator.comparingInt(Vehicle::getDistanceFromClient))
				.limit(3)
				.collect(Collectors.toList());

		System.out.println("\nfound " + availableVehicles.size() + " option:");
		for (int i = 0; i < availableVehicles.size(); i++) {
			Vehicle v = availableVehicles.get(i);
			System.out.println((i + 1) + ". " + v.getVehicleInfo());

			if (v instanceof Scooter) {
				Scooter scooter = (Scooter) v;
				System.out.println("   → " + scooter.getTripEstimate(tripDistance));
			}
		}

		return availableVehicles;
	}

	public void bookVehicle(Vehicle vehicle) {
		vehicle.setInTrip(true);
		System.out.println("\nbooked " + vehicle.getVehicleInfo());
	}

	public void releaseVehicle(Vehicle vehicle) {
		vehicle.setInTrip(false);
		System.out.println("trip done: " + vehicle.getVehicleInfo());
	}

	public void displayAllVehicles() {
		System.out.println("\n=== all vehicles ===");
		for (Vehicle v : vehicles) {
			String status = v.isInTrip() ? "[busy]" : "[free]";
			System.out.println(status + " " + v.getVehicleInfo());
		}
	}
}
