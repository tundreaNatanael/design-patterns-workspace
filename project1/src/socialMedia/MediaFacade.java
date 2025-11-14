package socialMedia;

public class MediaFacade {

	public MediaFacade() {
		// TODO Auto-generated constructor stub
	}

	public void postOnInstagram(String message) {
		SocialMedia i = new Instagram();
		i.post(message);
	}

	public void postOnTikTok(String message) {
		SocialMedia i = new TikTok();
		i.post(message);
	}

}
