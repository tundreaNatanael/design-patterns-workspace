package gameEntities;

import java.util.List;

import project1.Position;

public interface MovingEntity {

	void moveTo(Position newPosition);
    Position getPosition();
    int getTotalSize();
    String toString();
}
