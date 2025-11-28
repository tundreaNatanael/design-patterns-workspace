package project1;

public class Message {
	private int recieverId;
	private int senderId;
	private String message;

	public Message(int recieverId, String message) {
		this.recieverId = recieverId;
		this.message = message;
	}

	public int getRecieverId() {
		return recieverId;
	}

	public String getMessage() {
		return message;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

}
