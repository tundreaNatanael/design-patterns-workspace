package project1;

public class Client {
	private int id;
	private boolean active = false;
	private Server server;

	public Client(int id) {
		this.id = id;
	}

	public void addServer(Server server) {
		this.server = server;
		server.signupClient(this);
	}

	public void sendMessage(Message message) {
		message.setSenderId(this.id);
		server.sendMessage(message);
	}

	public void recieveMessage(Message message) {
		System.out.println(this.id + " recieved: '" + message.getMessage() + "' from " + message.getSenderId());
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getId() {
		return this.id;
	}

	public void getMyMessages() {
		for (Message message : this.server.getMyMessages(this.id)) {
			this.recieveMessage(message);
		}
	}

}
