package houses;

import project1.Position;

public class EuropeanHouse extends House {

	public EuropeanHouse(Position position, int width, int length) {
		this.position = position;
		this.width = width;
		this.length = length;
		this.material = "Concrete";
		this.roofType = "Tile";
	}

	@Override
	public String toString() {
		return String.format("European House [%s, %s roof] at (%d,%d) size: %dx%d", material, roofType, position.getX(),
				position.getY(), width, length);
	}

}
