package project1;

public class Route {
	private int distance = 0;
	private MovingType type = null;

	public Route(int distance) {
		this.distance = distance;
	}

	public void setMovingType(MovingType type) {
		this.type = type;
	}

	public int getDistance() {
		return distance;
	}

	public MovingType getType() {
		return type;
	}

}
