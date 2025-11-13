package project1;

import gameEntities.Character;
import gameEntities.CharacterGroup;
import gameEntities.MovingEntity;
import houses.House;
import scenes.AfricanSceneBuilder;
import scenes.SceneBuilder;

public class Main {

	public static void main(String[] args) {
		SceneBuilder ethiopia = new AfricanSceneBuilder();
		House nairobi = ethiopia.createHouse(new Position(2, 3), 10, 10);

		Board.getInstance().initialize(1000, 1000, ethiopia, 0, 0);

		Board.getInstance().addHouse(nairobi);

		MovingEntity elf1 = new Character(3, "elf", 300, new Position(300, 500));
		Board.getInstance().addEntity(elf1);
		elf1.moveTo(new Position(100, 100));

		CharacterGroup eflGroup = new CharacterGroup("Elft Alpha Team", new Position(100, 100));
		eflGroup.addMember(new Character(4, "elf", 250, new Position(0, 0)));
		eflGroup.addMember(new Character(5, "elf", 600, new Position(5, 5)));
		eflGroup.addMember(new Character(6, "elf", 78, new Position(3, 10)));

		eflGroup.moveTo(new Position(101, 102));
		eflGroup.moveTo(new Position(300, 102));

		Board.getInstance().addEntity(eflGroup);
		Board.getInstance().render();

	}

}
