package project1;

import houses.House;
import scenes.AfricanSceneBuilder;
import scenes.SceneBuilder;

public class Main {

	public static void main(String[] args) {
		SceneBuilder ethiopia = new AfricanSceneBuilder();
		House nairobi = ethiopia.createHouse(new Position(2, 34), 10, 10);
		System.out.println(nairobi.toString());
	}

}
