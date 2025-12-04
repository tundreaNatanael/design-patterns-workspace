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
		return true;
	}

	@Override
	public String getVehicleInfo() {
		return String.format("Car %s - %d km away", id, distanceFromClient);
	}
}
