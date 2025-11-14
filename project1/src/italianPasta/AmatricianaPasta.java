package italianPasta;

public class AmatricianaPasta extends Pasta {

	@Override
	protected void addBaseSauce() {
		System.out.println("Step 1 => Adding guanciale and onions on low heat");

	}

	@Override
	protected void addCondiments() {
		System.out.println("Step 3 => Adding basil, oregano, pepper and red chilli");

	}

	@Override
	protected void addMainSauce() {
		System.out.println("Step 4 => Adding tomato sauce");

	}

	@Override
	protected void addCheese() {
		System.out.println("Step 6 => Adding pecorino cheese");

	}

}
