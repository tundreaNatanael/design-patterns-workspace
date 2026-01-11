// PATTERN: decorator
package project1.trade;

public class FeeWrap implements Cost {
	private Cost _base;
	private double _rate;

	public FeeWrap(Cost base, double rate) {
		_base = base;
		_rate = rate;
	}

	@Override
	public double calc(double base) {
		return _base.calc(base) + (base * _rate);
	}
}
