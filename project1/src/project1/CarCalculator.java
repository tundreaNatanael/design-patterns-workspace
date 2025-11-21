package project1;

public class CarCalculator implements TimeCalculator {

	private Route route;

	public CarCalculator(Route route) {
		this.route = route;
	}

	@Override
	public int getRouteMinutes(Route route) {
		// TODO Auto-generated method stub
		return route.getDistance() / route.getType().getSpeed() * 60;
	}

}
