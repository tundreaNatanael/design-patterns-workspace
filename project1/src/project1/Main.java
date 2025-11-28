package project1;

public class Main {

	public static void main(String[] args) {
		Server s = new Server();
		Client c1 = new Client(1);
		Client c2 = new Client(2);

		c1.addServer(s);
		c2.addServer(s);

		c1.setActive(true);
		c2.setActive(true);

		c1.sendMessage(new Message(2, "Salut!"));

		c2.setActive(false);
		c1.sendMessage(new Message(2, "Ce faci!?"));
		c1.sendMessage(new Message(2, "Esti bine?"));
		c2.setActive(true);
		c2.getMyMessages();

	}

}
