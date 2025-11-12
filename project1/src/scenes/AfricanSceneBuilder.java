package scenes;

import houses.AfricanHouse;
import houses.House;
import project1.Position;

public class AfricanSceneBuilder extends SceneBuilder {

	@Override
	public House createHouse(Position position, int width, int length) {
		return new AfricanHouse(position, width, length);
	}

}
