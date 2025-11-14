package project1;

import socialMedia.SocialMediaFacade;

public class Main {

	final static String MESSAGE = "Check me out";

	public static void main(String[] args) {
		SocialMediaFacade instance = new SocialMediaFacade();
		System.out.println("\nPosting on media based social medias");
		instance.postOnMediaBased(MESSAGE);
		System.out.println("\nPosting on text based social medias");
		instance.postOnTextBased(MESSAGE);
	}

}
