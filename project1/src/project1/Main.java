package project1;

public class Main {

	public static void main(String[] args) {
		MovingType volvo = new Car();
		MovingType cube = new Bike();
		MovingType person1 = new Person();

		Route route = new Route(400);
		route.setMovingType(volvo);

		TimeCalculator carcalc = new CarCalculator(route);
//		TimeCalculator bikecalc = new BikeCalculator(route);
//		TimeCalculator perscalc = new PersonCalculator(route);

		System.out.println(carcalc.getRouteMinutes(route));
	}

}
