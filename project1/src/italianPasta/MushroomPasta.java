package italianPasta;

public class MushroomPasta extends Pasta {

	@Override
	protected void addBaseSauce() {
		System.out.println("Step 1 => Adding mushrooms on high heat");
	}

	@Override
	protected void addCondiments() {
		System.out.println("Step 3 => Adding garlic, salt and pepper");

	}

	@Override
	protected void addMainSauce() {
		System.out.println("Step 4 => Adding pasta water, butter and heavy milk cream");

	}

	@Override
	protected void addCheese() {
		System.out.println("Step 6 => Adding pecorino and parmigiano cheese");

	}

}
