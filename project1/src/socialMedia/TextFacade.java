package socialMedia;

public class TextFacade {

	public TextFacade() {
		// TODO Auto-generated constructor stub
	}

	public void postOnFacebook(String message) {
		SocialMedia i = new Facebook();
		i.post(message);
	}

	public void postOnTwitter(String message) {
		SocialMedia i = new Twitter();
		i.post(message);
	}

	public void postOnSlack(String message) {
		SocialMedia i = new Slack();
		i.post(message);
	}

	public void postOnWhatsApp(String message) {
		SocialMedia i = new WhatsApp();
		i.post(message);
	}

}
