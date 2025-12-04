package project1;

public class Scooter extends Vehicle {
	private int maxRange;

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
		double minimumRequired = tripDistance * 0.5;
		return maxRange >= minimumRequired;
	}

	@Override
	public String getVehicleInfo() {
		return String.format("Scooter %s - %d km away, range %d km", id, distanceFromClient, maxRange);
	}

	public String getTripEstimate(int tripDistance) {
		if (maxRange >= tripDistance) {
			return String.format("can do full trip (%d km)", tripDistance);
		} else {
			return String.format("only goes %d of %d km", maxRange, tripDistance);
		}
	}
}
