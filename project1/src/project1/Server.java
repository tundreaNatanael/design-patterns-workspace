package project1;

import java.util.ArrayList;
import java.util.List;

public class Server {
	private List<Client> clients;
	private List<Message> pendingMessages;

	public Server() {
		clients = new ArrayList<Client>();
		pendingMessages = new ArrayList<Message>();
	}

	public void signupClient(Client client) {
		clients.add(client);
	}

	public void sendMessage(Message message) {
		Client recieverInstance = null;
		for (Client client : clients) {
			if (client.getId() == message.getRecieverId())
				recieverInstance = client;
		}

		if (recieverInstance.getActive())
			recieverInstance.recieveMessage(message);
		else
			this.savePendingMessage(message);
	}

	public void savePendingMessage(Message message) {
		this.pendingMessages.add(message);
	}

	public List<Message> getMyMessages(int clientId) {
		List<Message> myMessages = new ArrayList<Message>();
		for (Message message : this.pendingMessages) {
			if (message.getRecieverId() == clientId)
				myMessages.add(message);
		}
		return myMessages;
	}

}
