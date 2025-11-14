package italianPasta;

public class ZozzonaPasta extends Pasta {

	@Override
	protected void addBaseSauce() {
		System.out.println("Step 1 => Adding guanciale, salsiccia and onions on low heat");

	}

	@Override
	protected void addCondiments() {
		System.out.println("Step 3 => Adding basil, oregano, pepper and red chilli");

	}

	@Override
	protected void addMainSauce() {
		System.out.println("Step 4 => Adding tomato sauce and eggs & pecorino cheese mixture");
	}

	@Override
	protected void addCheese() {
		System.out.println("Step 6 => Adding some pecorino and parmigiano cheese");

	}

}
