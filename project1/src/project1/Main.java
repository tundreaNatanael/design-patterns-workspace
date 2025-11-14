package project1;

import socialMedia.SocialMediaPostingFacade;

public class Main {

	public static void main(String[] args) {
		SocialMediaPostingFacade s = new SocialMediaPostingFacade();
		s.postOnFacebook("Check me out");
		s.postOnInstagram("Check me out");
		s.postOnTikTok("Check me out");
	}

}
