package scenes;

import houses.House;
import project1.Position;

public abstract class SceneBuilder {

	public abstract House createHouse(Position position, int width, int length);

}
