package project1;

public abstract class MovingType {
	private int speed;
	private int kmRange;

	public MovingType(int speed) {
		this.speed = speed;
	}

	public MovingType(int speed, int range) {
		this.speed = speed;
		this.kmRange = range;
	}

	public int getSpeed() {
		return speed;
	}

	public int getKmRange() {
		return kmRange;
	}

}
