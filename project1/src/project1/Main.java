package project1;

import italianPasta.AmatricianaPasta;
import italianPasta.CarbonaraPasta;
import italianPasta.MushroomPasta;
import italianPasta.Pasta;
import italianPasta.ZozzonaPasta;

public class Main {

	public static void main(String[] args) {

		System.out.println("Cooking pasta carbonara");
		Pasta carbonaraPasta = new CarbonaraPasta();
		carbonaraPasta.preparePasta();

		System.out.println("\nCooking pasta amatriciana");
		Pasta amatricianaPasta = new AmatricianaPasta();
		amatricianaPasta.preparePasta();

		System.out.println("\nCooking pasta al zozzona");
		Pasta zozzonaPasta = new ZozzonaPasta();
		zozzonaPasta.preparePasta();

		System.out.println("\nCooking pasta with mushrooms");
		Pasta mushroomPasta = new MushroomPasta();
		mushroomPasta.preparePasta();
	}

}
