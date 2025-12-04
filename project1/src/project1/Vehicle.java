package project1;

public abstract class Vehicle {
	protected String id;
	protected int distanceFromClient; // 1-100 km
	protected boolean inTrip;

	public Vehicle(String id, int distanceFromClient) {
		this.id = id;
		this.distanceFromClient = distanceFromClient;
		this.inTrip = false;
	}

	public String getId() {
		return id;
	}

	public int getDistanceFromClient() {
		return distanceFromClient;
	}

	public boolean isInTrip() {
		return inTrip;
	}

	public void setInTrip(boolean inTrip) {
		this.inTrip = inTrip;
	}

	public void setDistanceFromClient(int distance) {
		this.distanceFromClient = distance;
	}

	public abstract String getVehicleType();

	public abstract boolean canCompleteTrip(int tripDistance);

	public abstract String getVehicleInfo();
}
