package italianPasta;

public class CarbonaraPasta extends Pasta {

	@Override
	protected void addBaseSauce() {
		System.out.println("Step 1 => Adding guanciale on low heat");

	}

	@Override
	protected void addCondiments() {
		System.out.println("Step 3 => Adding grounded pepper");

	}

	@Override
	protected void addMainSauce() {
		System.out.println("Step 4 => Adding eggs & pecorino cheese mixture");

	}

	@Override
	protected void addCheese() {
		System.out.println("Step 6 => Adding Parmigiano cheese");

	}

}
