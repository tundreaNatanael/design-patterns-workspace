package socialMedia;

public class SocialMediaPostingFacade {

	public SocialMediaPostingFacade() {
		// TODO Auto-generated constructor stub
	}

	public void postOnFacebook(String message) {
		SocialMedia fb = new Facebook();
		fb.post(message);
	}

	public void postOnInstagram(String message) {
		SocialMedia instagram = new Instagram();
		instagram.post(message);
	}

	public void postOnTikTok(String message) {
		SocialMedia tikTok = new TikTok();
		tikTok.post(message);
	}

}
