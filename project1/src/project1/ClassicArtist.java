package project1;

public class ClassicArtist extends Artist {

	@Override
	public Song composeSong() {
		return new ClassicSong("Symphony IX", 20000);
	}

}
