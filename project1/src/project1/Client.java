package project1;

public class Client {
	private String name;
	private int location;

	public Client(String name, int location) {
		this.name = name;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}
}
