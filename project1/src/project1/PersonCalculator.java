package project1;

public class PersonCalculator implements TimeCalculator {

	private Route route;

	public PersonCalculator(Route route) {
		this.route = route;
	}

	@Override
	public int getRouteMinutes(Route route) {
		// TODO Auto-generated method stub
		return route.getDistance() / route.getType().getSpeed() * 60 + route.getType().getKmRange() * 5;
	}

}
