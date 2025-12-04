package project1;

public class Scooter extends Vehicle {
	private int maxRange; // Maximum km the scooter can travel with current charge

	public Scooter(String id, int distanceFromClient, int maxRange) {
		super(id, distanceFromClient);
		this.maxRange = maxRange;
	}

	public int getMaxRange() {
		return maxRange;
	}

	@Override
	public String getVehicleType() {
		return "Scooter";
	}

	@Override
	public boolean canCompleteTrip(int tripDistance) {
		// Scooter must be able to do at least 50% of the trip
		double minimumRequired = tripDistance * 0.5;
		return maxRange >= minimumRequired;
	}

	@Override
	public String getVehicleInfo() {
		return String.format("Scooter %s - Distance: %d km, Max Range: %d km", id, distanceFromClient, maxRange);
	}

	public String getTripEstimate(int tripDistance) {
		if (maxRange >= tripDistance) {
			return String.format("Can complete full trip (%d km)", tripDistance);
		} else {
			return String.format("Can go %d km out of %d km requested", maxRange, tripDistance);
		}
	}
}
