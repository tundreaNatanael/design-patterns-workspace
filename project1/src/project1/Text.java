package project1;

public abstract class Text extends Div {

	protected String text = null;
	protected String color = null;
	protected boolean bold = false;

	public Text(String text) {
		this.text = text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setBold(boolean bold) {
		this.bold = bold;
	}

}
