package project1;

public class RockArtist extends Artist {

	@Override
	public Song composeSong() {
		return new RockSong("Bohemian Rhapsody", 10000);
	}

}
