// PATTERN: decorator
package project1.trade;

public class PenaltyWrap extends FeeWrap {
	public PenaltyWrap(Cost base) {
		super(base, 0.05);
	}
}
