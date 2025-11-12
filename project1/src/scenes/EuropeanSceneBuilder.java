package scenes;

import houses.EuropeanHouse;
import houses.House;
import project1.Position;

public class EuropeanSceneBuilder extends SceneBuilder {

	@Override
    public House createHouse(Position position, int width, int length) {
        return new EuropeanHouse(position, width, length);
    }

}
