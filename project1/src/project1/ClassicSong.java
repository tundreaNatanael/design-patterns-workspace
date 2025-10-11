package project1;

public class ClassicSong implements Song {

	private String name;
	private int plays;
	
	public ClassicSong(String name, int plays) {
		this.name = name;
		this.plays = plays;
	}

	@Override
	public void sing() {
		System.out.println(this.toString());
		
	}

	@Override
	public String toString() {
		return "ClassicSong [name=" + name + ", plays=" + plays + "]";
	}
	
	

}
