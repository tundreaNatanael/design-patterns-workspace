package houses;

import java.util.ArrayList;
import java.util.List;

import project1.Position;

public abstract class House {

	protected Position position;
	protected int width;
	protected int length;
	protected String material;
	protected String roofType;

	public abstract String toString();

	public Position getPosition() {
		return position;
	}

	public int getWidth() {
		return width;
	}

	public int getLength() {
		return length;
	}

	public String getMaterial() {
		return material;
	}

	public String getRoofType() {
		return roofType;
	}

	public List<Position> getOccupiedArea() {
		List<Position> area = new ArrayList<>();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < length; j++) {
				area.add(new Position(position.getX() + i, position.getY() + j));
			}
		}
		return area;
	}

}
