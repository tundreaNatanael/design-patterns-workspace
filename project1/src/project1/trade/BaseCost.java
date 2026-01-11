// PATTERN: decorator
package project1.trade;

public class BaseCost implements Cost {
	@Override
	public double calc(double base) {
		return base;
	}
}
