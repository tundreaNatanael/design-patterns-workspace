package project1;

import java.util.ArrayList;
import java.util.List;

import gameEntities.MovingEntity;
import houses.House;
import scenes.SceneBuilder;

public class Board {
	private static Board instance;
	private int width;
	private int height;
	private SceneBuilder sceneType;
	private int nrHouses;
	private int nrCharacters;
	private List<House> houses = new ArrayList<>();
	private List<MovingEntity> entities = new ArrayList<>();
	private boolean[][] occupiedGrid;

	private Board() {
	}

	public static Board getInstance() {
		if (instance == null) {
			instance = new Board();
			return instance;
		}
		return instance;
	}

	public void initialize(int width, int height, SceneBuilder sceneType, int nrHouses, int nrCharacters) {
		this.width = width;
		this.height = height;
		this.occupiedGrid = new boolean[width][height];
		this.sceneType = sceneType;
		this.nrHouses = nrHouses;
//		for(int i=1; i<= nrHouses; i++) {
//			
//		}
		this.nrCharacters = nrCharacters;

	}

	public void addHouse(House house) {
		houses.add(house);

		for (Position pos : house.getOccupiedArea()) {
			if (isValidPosition(pos)) {
				occupiedGrid[pos.getX()][pos.getY()] = true;
			}
		}
	}

	public void addEntity(MovingEntity entity) {
		if (this.canMoveTo(entity.getPosition()))
			entities.add(entity);
		else
			System.out.println("!!! There is already someone there");
	}

	public boolean canMoveTo(Position position) {
		return canMoveTo(position, new ArrayList<Position>());
	}

	public boolean canMoveTo(Position position, List<Position> charactersFuturePositions) {
		charactersFuturePositions.add(position);

		for (Position checkPos : charactersFuturePositions) {
			if (!isValidPosition(checkPos) || occupiedGrid[checkPos.getX()][checkPos.getY()]) {
				return false;
			}
		}
		return true;
	}

	private boolean isValidPosition(Position pos) {
		return pos.getX() >= 0 && pos.getX() < width && pos.getY() >= 0 && pos.getY() < height;
	}

	public void render() {
		System.out.println("\n<=== GAME BOARD ===>");
		System.out.println("Board Size: " + width + " x " + height);
		System.out.println("\n--- HOUSES ---");
		for (House house : houses) {
			System.out.println(house.toString());
		}
		System.out.println("\n--- ENTITIES ---");
		for (MovingEntity entity : entities) {
			System.out.println(entity.toString() + "\n");
		}
		System.out.println("======================\n");
	}
}
