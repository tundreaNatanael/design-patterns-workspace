package houses;

import project1.Position;

public class AsianHouse extends House {

	public AsianHouse(Position pos, int width, int length) {
		this.position = pos;
		this.width = width;
		this.length = length;
		this.material = "Bamboo";
		this.roofType = "Curved Asian Style";
	}

	@Override
	public String toString() {
		return String.format("Asian House [%s, %s roof] at (%d,%d) size: %dx%d", material, roofType, position.getX(),
				position.getY(), width, length);
	}

}
