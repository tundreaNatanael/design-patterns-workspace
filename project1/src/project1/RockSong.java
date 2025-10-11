package project1;

public class RockSong implements Song {

	private String name;
	private int plays;
	
	public RockSong(String name, int plays) {
		this.name = name;
		this.plays = plays;
	}

	@Override
	public void sing() {
		System.out.println(this.toString());
		
	}

	@Override
	public String toString() {
		return "RockSong [name=" + name + ", plays=" + plays + "]";
	}

}
