// PATTERN: composite
package project1.model;

import java.util.List;

import project1.core.Store;

public interface Node {
	double totalValue(Store store);

	List<Holding> getHoldings();
}
