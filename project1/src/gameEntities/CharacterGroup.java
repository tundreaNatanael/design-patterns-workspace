package gameEntities;

import java.util.ArrayList;
import java.util.List;

import project1.Board;
import project1.Position;

public class CharacterGroup implements MovingEntity {

	private String name;
	private List<MovingEntity> members = new ArrayList<>();
	private Position position;

	public CharacterGroup(String name, Position position) {
		this.name = name;
		this.position = position;
	}

	public void addMember(MovingEntity entity) {
		members.add(entity);
	}

	public void removeMember(MovingEntity entity) {
		members.remove(entity);
	}

	@Override
	public void moveTo(Position newPosition) {

		List<Position> charactersFuturePositions = new ArrayList<>();
		for (MovingEntity member : this.members) {
			int xDifference = newPosition.getX() - this.position.getX();
			int yDifference = newPosition.getY() - this.position.getY();
			charactersFuturePositions.add(
					new Position(member.getPosition().getX() + xDifference, member.getPosition().getY() + yDifference));
		}

		if (Board.getInstance().canMoveTo(newPosition, charactersFuturePositions)) {

			int xDifference = newPosition.getX() - this.position.getX();
			int yDifference = newPosition.getY() - this.position.getY();

			for (MovingEntity member : this.members) {
				member.moveTo(new Position(member.getPosition().getX() + xDifference,
						member.getPosition().getY() + yDifference));
			}
			this.position = newPosition;
			System.out.println("Group " + name + " moved to (" + newPosition.getX() + ", " + newPosition.getY() + ")");
		} else {
			System.out.println("Cannot move group " + name + " to (" + newPosition.getX() + ", " + newPosition.getY()
					+ ")" + " - insufficient space");
		}

	}

	@Override
	public Position getPosition() {
		return this.position;
	}

	@Override
	public int getTotalSize() {
		return members.size();
	}

	public List<Position> getOccupiedPositions() {
		List<Position> area = new ArrayList<>();

		for (MovingEntity member : this.members) {
			area.add(member.getPosition());
		}
		return area;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("Character Group %s [%s characters] at (%d,%d)", this.name, this.getTotalSize(),
				this.position.getX(), this.position.getY()));
		for (MovingEntity character : this.members) {
			result.append("\n" + character.toString());
		}

		return result.toString();

	}

}
