package gameEntities;

import java.util.List;

import project1.Board;
import project1.Position;

public class Character implements MovingEntity {

	private int id;
	private String type;
	private int age;
	private Position position;
	private List<String> abilities;

	public Character(int id, String type, int age, Position position) {
		this.id = id;
		this.type = type;
		this.age = age;
		this.position = position;
	}

	@Override
	public void moveTo(Position newPosition) {
		if (Board.getInstance().canMoveTo(newPosition)) {
			this.position = newPosition;
			System.out.println(this.id + " moved to (" + this.position.getX() + ", " + this.position.getY() + ")");
		} else {
			System.out.println("Cannot move " + this.id + " to (" + this.position.getX() + ", " + this.position.getY()
					+ ") - position occupied");
		}

	}

	@Override
	public Position getPosition() {
		return this.position;
	}

	@Override
	public int getTotalSize() {
		return 0;
	}

	@Override
	public String toString() {
		return String.format("- Character %s [%s, age: %s] at (%d,%d)", this.id, this.type, this.age,
				this.position.getX(), this.position.getY());
	}

}
