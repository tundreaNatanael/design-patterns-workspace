package project1;

public class Car extends Vehicle {

	public Car(String id, int distanceFromClient) {
		super(id, distanceFromClient);
	}

	@Override
	public String getVehicleType() {
		return "Car";
	}

	@Override
	public boolean canCompleteTrip(int tripDistance) {
		// Cars can always complete any trip (no range limitation)
		return true;
	}

	@Override
	public String getVehicleInfo() {
		return String.format("Car %s - Distance: %d km", id, distanceFromClient);
	}
}
