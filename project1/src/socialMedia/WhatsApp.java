package socialMedia;

class WhatsApp extends SocialMedia {

	public WhatsApp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	void post(String message) {
		System.out.println("Postin on WhatsApp:	" + message);
	}

}
