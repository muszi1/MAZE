package mazestate.modell;

import modell.Direction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DirectionTest {

    @Test
    public void testEnumValues() {
        assertEquals(Direction.UP, Direction.valueOf("UP"));
        assertEquals(Direction.RIGHT, Direction.valueOf("RIGHT"));
        assertEquals(Direction.DOWN, Direction.valueOf("DOWN"));
        assertEquals(Direction.LEFT, Direction.valueOf("LEFT"));
    }

    @Test
    public void testEnumCount() {
        assertEquals(4, Direction.values().length);
    }

    @Test
    public void testEnumOrder() {
        Direction[] directions = Direction.values();
        assertEquals(Direction.UP, directions[0]);
        assertEquals(Direction.RIGHT, directions[1]);
        assertEquals(Direction.DOWN, directions[2]);
        assertEquals(Direction.LEFT, directions[3]);
    }
}
