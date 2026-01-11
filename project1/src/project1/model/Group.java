// PATTERN: composite
package project1.model;

import java.util.ArrayList;
import java.util.List;

import project1.core.Store;

public class Group implements Node {
	private List<Node> _nodes = new ArrayList<>();

	public void add(Node node) {
		if (node == null)
			return;
		_nodes.add(node);
	}

	public void remove(Node node) {
		_nodes.remove(node);
	}

	@Override
	public double totalValue(Store store) {
		double sum = 0;
		for (Node node : _nodes)
			sum += node.totalValue(store);
		return sum;
	}

	@Override
	public List<Holding> getHoldings() {
		List<Holding> out = new ArrayList<>();
		for (Node node : _nodes)
			out.addAll(node.getHoldings());
		return out;
	}
}
