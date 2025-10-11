package project1;

public class Main {

	public static void main(String[] args) {
		ClassicArtist beethoven = new ClassicArtist();
		beethoven.singSong();
		
		RockArtist queen = new RockArtist();
		queen.singSong();
		
		GeneralArtist generic = new GeneralArtist();
		generic.singSong("classic");
		generic.singSong("rock");
	}
	

}
