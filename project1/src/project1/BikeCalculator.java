package project1;

public class BikeCalculator implements TimeCalculator {

	private Route route;

	public BikeCalculator(Route route) {
		this.route = route;
	}

	@Override
	public int getRouteMinutes(Route route) {
		return route.getDistance() / route.getType().getSpeed() * 60 + route.getType().getKmRange() * 5;
	}

}
