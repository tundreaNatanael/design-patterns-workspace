package socialMedia;

public class SocialMediaFacade {

	public SocialMediaFacade() {
		// TODO Auto-generated constructor stub
	}

	public void postOnMediaBased(String message) {
		MediaFacade i = new MediaFacade();
		i.postOnInstagram(message);
		i.postOnTikTok(message);
	}

	public void postOnTextBased(String message) {
		TextFacade i = new TextFacade();
		i.postOnFacebook(message);
		i.postOnTwitter(message);
		i.postOnSlack(message);
		i.postOnWhatsApp(message);
	}

}
