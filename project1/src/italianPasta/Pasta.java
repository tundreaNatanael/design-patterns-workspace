package italianPasta;

public abstract class Pasta {

	public final void preparePasta() {
		addBaseSauce();
		boilPasta();
		addCondiments();
		addMainSauce();
		addPastaAlDente();
		addCheese();
	}

	protected abstract void addBaseSauce();

	private void boilPasta() {
		System.out.println("Step 2 => Boiling pasta");
	}

	protected abstract void addCondiments();

	protected abstract void addMainSauce();

	private void addPastaAlDente() {
		System.out.println("Step 5 => Adding al dente pasta");
	}

	protected abstract void addCheese();

}
