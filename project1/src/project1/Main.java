// PATTERN: facade
package project1;

import java.time.LocalDateTime;
import java.time.Month;

import project1.core.Gate;
import project1.core.Hub;
import project1.core.Maker;
import project1.core.Store;
import project1.model.User;
import project1.notify.Watch;
import project1.trade.PlanAuto;
import project1.trade.PlanDay;
import project1.trade.PlanLong;

public class Main {
	public static void main(String[] args) {
		AmazonStock amzStock = new AmazonStock("$", 1000, 20);

		PrivateInvestor johnDoeInvestor = new PrivateInvestor("john", amzStock);
		PublicInvestor vooInvestor = new PublicInvestor("voo", amzStock);

		amzStock.setPrice(1001);
		amzStock.unsubscribe(johnDoeInvestor);
		amzStock.setPrice(1000);
		amzStock.unsubscribe(vooInvestor);

		Store store = Store.get();
		Maker maker = new Maker();
		store.add(amzStock);
		store.add(maker.make("Tesla", "TSL", "$", 200, 30, false));
		store.add(maker.make("Bitcoin", "BTC", "$", 5000, 5, true));

		Hub hub = new Hub(store);
		Gate gate = new Gate(hub);

		gate.register("ana", "1");
		gate.register("bob", "2");
		gate.register("max", "3");

		User ana = gate.login("ana", "1");
		User bob = gate.login("bob", "2");
		User max = gate.login("max", "3");

		gate.setPlan(ana, new PlanDay());
		PlanAuto auto = new PlanAuto();
		auto.set("BTC", 5001, 4999);
		gate.setPlan(bob, auto);
		gate.setPlan(max, new PlanLong());

		gate.watch(ana, "AMZ", new Watch());

		LocalDateTime closedTime = LocalDateTime.of(2024, Month.MARCH, 2, 20, 0);
		gate.buy(ana, "AMZ", 1, closedTime);

		LocalDateTime openTime = LocalDateTime.of(2024, Month.MARCH, 4, 10, 0);
		gate.buy(ana, "AMZ", 2, openTime);
		gate.buy(max, "TSL", 1, openTime);
		gate.sell(max, "TSL", 1, openTime);

		LocalDateTime tickTime = openTime.plusHours(1);
		gate.tick(tickTime);

		LocalDateTime nextDay = openTime.plusDays(1);
		gate.tick(nextDay);
	}
}
