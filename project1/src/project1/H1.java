package project1;

public class H1 extends Text {

	public H1(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String generateHTML() {
		StringBuilder style = new StringBuilder();
		if (this.color != null)
			style.append("color: " + this.color + ";");
		if (this.backgroundColor != null)
			style.append("background-color: " + this.backgroundColor + ";");
		if (this.bold)
			style.append("font-weight: bold;");
		if (this.padding != 0)
			style.append("padding: " + this.padding + ";");
		if (this.margins != 0)
			style.append("margin: " + this.margins + ";");

		StringBuilder result = new StringBuilder();
		result.append("<h1");

		if (style.toString() != null && !style.toString().isEmpty())
			result.append(" style='" + style.toString() + "'");

		result.append(">");

		result.append(this.text + "</h1>");

		return result.toString();
	}

}
