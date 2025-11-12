package scenes;

import houses.AsianHouse;
import houses.House;
import project1.Position;

public class AsianSceneBuilder extends SceneBuilder {

	@Override
	public House createHouse(Position position, int width, int length) {
		return new AsianHouse(position, width, length);
	}

}
