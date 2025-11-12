package houses;

import project1.Position;

public abstract class House {
	
	protected Position position;
	protected int width;
    protected int length;
    protected String material;
    protected String roofType;
	
	public abstract String toString();

}
