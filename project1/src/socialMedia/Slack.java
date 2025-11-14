package socialMedia;

class Slack extends SocialMedia {

	public Slack() {
		// TODO Auto-generated constructor stub
	}

	@Override
	void post(String message) {
		System.out.println("Postin on Slack:	" + message);

	}

}
