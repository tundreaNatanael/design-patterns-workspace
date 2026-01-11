// PATTERN: command
package project1.trade;

import java.time.LocalDateTime;

import project1.Stock;
import project1.model.User;

public interface Act {
	void execute(User user, Stock item, int qty, LocalDateTime now);
}
