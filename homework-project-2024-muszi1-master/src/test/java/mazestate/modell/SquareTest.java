package mazestate.modell;

import modell.Position;
import modell.Square;
import modell.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SquareTest {

    private Square square;

    @BeforeEach
    public void setUp() {
        Position position = new Position(1, 1);
        Wall[] walls = {Wall.TOP, Wall.LEFT};
        square = new Square(position, walls, false, false);
    }

    @Test
    public void testInitialization() {
        Position position = new Position(1, 1);
        Wall[] walls = {Wall.TOP, Wall.LEFT};
        Square square = new Square(position, walls, false, false);

        assertEquals(position, square.getPosition());
        assertArrayEquals(walls, square.getWalls());
        assertFalse(square.isPlayer());
        assertFalse(square.isFinish());
    }

    @Test
    public void testSetPlayer() {
        square.setPlayer(true);
        assertTrue(square.isPlayer());

        square.setPlayer(false);
        assertFalse(square.isPlayer());
    }

    @Test
    public void testEquals() {
        Position position = new Position(1, 1);
        Wall[] walls = {Wall.TOP, Wall.LEFT};
        Square square1 = new Square(position, walls, false, false);
        Square square2 = new Square(position, walls, false, false);
        Square square3 = new Square(position, walls, true, false);

        assertEquals(square1, square2);
        assertNotEquals(square1, square3);
    }

    @Test
    public void testHashCode() {
        Position position = new Position(1, 1);
        Wall[] walls = {Wall.TOP, Wall.LEFT};
        Square square1 = new Square(position, walls, false, false);
        Square square2 = new Square(position, walls, false, false);

        assertEquals(square1.hashCode(), square2.hashCode());
    }

    @Test
    public void testToString() {
        Position position = new Position(1, 1);
        Wall[] walls = {Wall.TOP, Wall.LEFT};
        Square square = new Square(position, walls, false, false);

        String expected = "Square{position=(1,1), walls=[TOP, LEFT], isPlayer=false, isFinish=false}";
        assertEquals(expected, square.toString());
    }
}
