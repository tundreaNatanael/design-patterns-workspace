package houses;

import project1.Position;

public class AfricanHouse extends House {

	public AfricanHouse(Position pos, int width, int length) {
		this.position = pos;
		this.width = width;
		this.length = length;
		this.material = "Dirt";
		this.roofType = "Cane";
	}

	@Override
	public String toString() {
		return String.format("African House [%s, %s roof] at (%d,%d) size: %dx%d", material, roofType, position.getX(),
				position.getY(), width, length);
	}

}
