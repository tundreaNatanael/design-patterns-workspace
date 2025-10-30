package project1;

import java.util.ArrayList;
import java.util.List;

public class Div {
	protected String backgroundColor;
	protected int padding;
	protected int margins;
	protected List<Div> children;

	public Div() {
		this.backgroundColor = null;
		this.padding = 0;
		this.margins = 0;
		this.children = new ArrayList<Div>();
	}

	public Div(String backgroundColor, int padding, int margins, List<Div> children) {
		this.backgroundColor = backgroundColor;
		this.padding = padding;
		this.margins = margins;
		this.children = children;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public void setPadding(int padding) {
		this.padding = padding;
	}

	public void setMargins(int margins) {
		this.margins = margins;
	}

	public void addChild(Div child) {
		this.children.add(child);
	}

	public String generateHTML() {
		StringBuilder style = new StringBuilder();
		if (this.backgroundColor != null)
			style.append("background-color: " + this.backgroundColor + ";");
		if (this.padding != 0)
			style.append(" padding: " + this.padding + ";");
		if (this.margins != 0)
			style.append(" margin: " + this.margins + ";");

		StringBuilder children = new StringBuilder();
		for (Div child : this.children) {
			children.append(child.generateHTML());
		}

		StringBuilder result = new StringBuilder();
		result.append("<div");

		if (style.toString() != null && !style.toString().isEmpty())
			result.append(" style='" + style.toString() + "'");

		result.append(">");

		if (children.toString() != null && !children.toString().isEmpty())
			result.append(children.toString());

		result.append("</div>");

		return result.toString();

	}

}
