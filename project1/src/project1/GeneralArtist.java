package project1;

//Simple factory example
public class GeneralArtist {

	public Song composeSong(String type) {
		switch (type.toLowerCase()) {
        case "classic":
            return new ClassicSong("Symphony IX", 20000);
        case "rock":
            return new RockSong("Bohemian Rhapsody", 10000);
        default:
            throw new IllegalArgumentException("Unknown song type: " + type);
        }
	}
	
	public void singSong(String type) {
		Song song = composeSong(type);
		song.sing();
	}

}
