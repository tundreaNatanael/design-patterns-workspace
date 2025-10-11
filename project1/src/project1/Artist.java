package project1;

//Factory method example
public abstract class Artist {
	
	public abstract Song composeSong();
	
	public void singSong() {
		Song song = composeSong();
		song.sing();
	}

}
