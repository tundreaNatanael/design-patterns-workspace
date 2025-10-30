package project1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		try {
			// Read JSON file
			String jsonContent = readFile("noCodeHTML.json");

			// Parse JSON and create HTML structure
			Div rootDiv = parseElement(jsonContent);

			// Generate HTML
			String html = generateCompleteHTML(rootDiv);

			// Save to file
			FileWriter writer = new FileWriter("output.html");
			writer.write(html);
			writer.close();

			System.out.println("HTML file generated successfully!");
			System.out.println("\nGenerated HTML:\n");
			System.out.println(html);

		} catch (IOException e) {
			System.err.println("Error reading/writing file: " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static String readFile(String filename) throws IOException {
		StringBuilder content = new StringBuilder();
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String line;
		while ((line = reader.readLine()) != null) {
			content.append(line);
		}
		reader.close();
		return content.toString();
	}

	private static Div parseElement(String json) {
		json = json.trim();

		// Extract type
		String type = getStringValue(json, "type");

		if (type == null) {
			throw new IllegalArgumentException("JSON element must have a 'type' field");
		}

		Div element = null;

		switch (type) {
		case "div":
			element = new Div();
			break;
		case "h1":
			String h1Text = getStringValue(json, "text");
			if (h1Text == null)
				h1Text = "";
			element = new H1(h1Text);

			String h1Color = getStringValue(json, "color");
			if (h1Color != null) {
				((H1) element).setColor(h1Color);
			}

			Boolean h1Bold = getBooleanValue(json, "bold");
			if (h1Bold != null) {
				((H1) element).setBold(h1Bold);
			}
			break;
		case "p":
			String pText = getStringValue(json, "text");
			if (pText == null)
				pText = "";
			element = new P(pText);

			String pColor = getStringValue(json, "color");
			if (pColor != null) {
				((P) element).setColor(pColor);
			}

			Boolean pBold = getBooleanValue(json, "bold");
			if (pBold != null) {
				((P) element).setBold(pBold);
			}
			break;
		default:
			throw new IllegalArgumentException("Unknown element type: " + type);
		}

		// Set common properties
		String backgroundColor = getStringValue(json, "backgroundColor");
		if (backgroundColor != null) {
			element.setBackgroundColor(backgroundColor);
		}

		Integer padding = getIntValue(json, "padding");
		if (padding != null) {
			element.setPadding(padding);
		}

		Integer margins = getIntValue(json, "margins");
		if (margins != null) {
			element.setMargins(margins);
		}

		// Parse children
		String childrenArray = getArrayValue(json, "children");
		if (childrenArray != null) {
			List<String> children = splitJsonArray(childrenArray);
			for (String child : children) {
				Div childElement = parseElement(child);
				element.addChild(childElement);
			}
		}

		return element;
	}

	private static String getStringValue(String json, String key) {
		// Look for "key" in the JSON
		String searchPattern = "\"" + key + "\"";
		int keyIndex = json.indexOf(searchPattern);

		if (keyIndex == -1) {
			return null;
		}

		// Start searching after the key
		int searchStart = keyIndex + searchPattern.length();

		// Find the colon
		int colonIndex = -1;
		for (int i = searchStart; i < json.length(); i++) {
			if (json.charAt(i) == ':') {
				colonIndex = i;
				break;
			}
		}

		if (colonIndex == -1) {
			return null;
		}

		// Find the opening quote after the colon
		int openQuoteIndex = -1;
		for (int i = colonIndex + 1; i < json.length(); i++) {
			char c = json.charAt(i);
			if (c == '"') {
				openQuoteIndex = i;
				break;
			} else if (!Character.isWhitespace(c)) {
				// Non-quote, non-whitespace character means this isn't a string value
				return null;
			}
		}

		if (openQuoteIndex == -1) {
			return null;
		}

		// Find the closing quote
		int closeQuoteIndex = -1;
		for (int i = openQuoteIndex + 1; i < json.length(); i++) {
			if (json.charAt(i) == '"' && json.charAt(i - 1) != '\\') {
				closeQuoteIndex = i;
				break;
			}
		}

		if (closeQuoteIndex == -1) {
			return null;
		}

		return json.substring(openQuoteIndex + 1, closeQuoteIndex);
	}

	private static Integer getIntValue(String json, String key) {
		// Look for "key" in the JSON
		String searchPattern = "\"" + key + "\"";
		int keyIndex = json.indexOf(searchPattern);

		if (keyIndex == -1) {
			return null;
		}

		// Start searching after the key
		int searchStart = keyIndex + searchPattern.length();

		// Find the colon
		int colonIndex = -1;
		for (int i = searchStart; i < json.length(); i++) {
			if (json.charAt(i) == ':') {
				colonIndex = i;
				break;
			}
		}

		if (colonIndex == -1) {
			return null;
		}

		// Skip whitespace after colon
		int numberStart = -1;
		for (int i = colonIndex + 1; i < json.length(); i++) {
			char c = json.charAt(i);
			if (Character.isDigit(c) || c == '-') {
				numberStart = i;
				break;
			} else if (!Character.isWhitespace(c)) {
				// Not a number
				return null;
			}
		}

		if (numberStart == -1) {
			return null;
		}

		// Find the end of the number
		int numberEnd = numberStart;
		while (numberEnd < json.length()
				&& (Character.isDigit(json.charAt(numberEnd)) || json.charAt(numberEnd) == '-')) {
			numberEnd++;
		}

		try {
			return Integer.parseInt(json.substring(numberStart, numberEnd));
		} catch (NumberFormatException e) {
			return null;
		}
	}

	private static Boolean getBooleanValue(String json, String key) {
		// Look for "key" in the JSON
		String searchPattern = "\"" + key + "\"";
		int keyIndex = json.indexOf(searchPattern);

		if (keyIndex == -1) {
			return null;
		}

		// Start searching after the key
		int searchStart = keyIndex + searchPattern.length();

		// Find the colon
		int colonIndex = -1;
		for (int i = searchStart; i < json.length(); i++) {
			if (json.charAt(i) == ':') {
				colonIndex = i;
				break;
			}
		}

		if (colonIndex == -1) {
			return null;
		}

		// Skip whitespace and check for true/false
		for (int i = colonIndex + 1; i < json.length(); i++) {
			char c = json.charAt(i);
			if (Character.isWhitespace(c)) {
				continue;
			}

			// Check if we have "true" or "false"
			String remaining = json.substring(i);
			if (remaining.startsWith("true")) {
				return true;
			} else if (remaining.startsWith("false")) {
				return false;
			} else {
				return null;
			}
		}

		return null;
	}

	private static String getArrayValue(String json, String key) {
		// Look for "key" in the JSON
		String searchPattern = "\"" + key + "\"";
		int keyIndex = json.indexOf(searchPattern);

		if (keyIndex == -1) {
			return null;
		}

		// Start searching after the key
		int searchStart = keyIndex + searchPattern.length();

		// Find the opening bracket
		int bracketStart = -1;
		for (int i = searchStart; i < json.length(); i++) {
			if (json.charAt(i) == '[') {
				bracketStart = i;
				break;
			}
		}

		if (bracketStart == -1) {
			return null;
		}

		// Find matching closing bracket
		int depth = 0;
		int bracketEnd = -1;
		for (int i = bracketStart; i < json.length(); i++) {
			if (json.charAt(i) == '[') {
				depth++;
			} else if (json.charAt(i) == ']') {
				depth--;
				if (depth == 0) {
					bracketEnd = i;
					break;
				}
			}
		}

		if (bracketEnd == -1) {
			return null;
		}

		return json.substring(bracketStart + 1, bracketEnd);
	}

	private static List<String> splitJsonArray(String arrayContent) {
		List<String> elements = new ArrayList<>();
		if (arrayContent == null || arrayContent.trim().isEmpty()) {
			return elements;
		}

		int depth = 0;
		int start = 0;
		boolean inString = false;

		for (int i = 0; i < arrayContent.length(); i++) {
			char c = arrayContent.charAt(i);

			// Track if we're inside a string
			if (c == '"' && (i == 0 || arrayContent.charAt(i - 1) != '\\')) {
				inString = !inString;
			}

			// Only count braces when not in a string
			if (!inString) {
				if (c == '{') {
					if (depth == 0) {
						start = i;
					}
					depth++;
				} else if (c == '}') {
					depth--;
					if (depth == 0) {
						elements.add(arrayContent.substring(start, i + 1));
					}
				}
			}
		}

		return elements;
	}

	private static String generateCompleteHTML(Div root) {
		StringBuilder html = new StringBuilder();
		html.append("<!DOCTYPE html>\n");
		html.append("<html>\n");
		html.append("<head>\n");
		html.append("    <meta charset='UTF-8'>\n");
		html.append("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n");
		html.append("    <title>Generated Page</title>\n");
		html.append("</head>\n");
		html.append("<body>\n");
		html.append("    ");
		html.append(root.generateHTML());
		html.append("\n");
		html.append("</body>\n");
		html.append("</html>");
		return html.toString();
	}
}