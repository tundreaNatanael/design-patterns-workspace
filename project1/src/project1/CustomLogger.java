package project1;

public class CustomLogger {

	private String loggerName;
	private static int emailInstances = 0;
	private static CustomLogger currentInstance;
	
	private CustomLogger(String loggerName) {
		emailInstances ++;
		this.loggerName = loggerName;
	}
	
	public static CustomLogger CustomLoggerConstructor(String loggerName) {
		if(emailInstances == 0)
			currentInstance = new CustomLogger(loggerName);
		
		
		return currentInstance;
	}

	@Override
	public String toString() {
		return "loggerName: " + this.loggerName + "	-	CustomLogger [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
