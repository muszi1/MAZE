package mazestate.modell;

import modell.Direction;
import modell.MazeState;
import modell.Position;
import modell.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MazeStateTest {

    private MazeState mazeState;

    @BeforeEach
    public void setUp() {
        mazeState = new MazeState(TestMaze.TEST_MAZE);
    }

    @Test
    public void testInitialization() {
        assertNotNull(mazeState.getSquare(0, 0));
        assertEquals(7, MazeState.BOARD_SIZE_WIDTH);
        assertEquals(7, MazeState.BOARD_SIZE_HEIGTH);
    }

    @Test
    public void testGetSquare() {
        Square square = mazeState.getSquare(0, 0);
        assertEquals(new Position(0, 0), square.getPosition());
        assertFalse(square.isPlayer());
        assertFalse(square.isFinish());
    }

    @Test
    public void testIsLegalMove() {
        assertFalse(mazeState.isLegalMove(Direction.UP));
        assertFalse(mazeState.isLegalMove(Direction.RIGHT));
        assertTrue(mazeState.isLegalMove(Direction.DOWN));
        assertTrue(mazeState.isLegalMove(Direction.LEFT));
    }

    @Test
    public void testMakeMove() {
        mazeState.makeMove(Direction.DOWN);
        mazeState.makeMove(Direction.LEFT);
        mazeState.makeMove(Direction.DOWN);
        mazeState.makeMove(Direction.LEFT);
        mazeState.makeMove(Direction.UP);
        mazeState.makeMove(Direction.RIGHT);
        mazeState.makeMove(Direction.DOWN);

        assertTrue(mazeState.getSquare(6, 6).isPlayer());
    }

    @Test
    public void testMakeMoveDown() {
        mazeState.makeMove(Direction.DOWN);
        assertFalse(mazeState.getSquare(2, 6).isPlayer());
        assertTrue(mazeState.getSquare(3, 6).isPlayer());
    }

    @Test
    public void testMakeMoveLeft() {
        mazeState.makeMove(Direction.LEFT);
        assertTrue(mazeState.getSquare(1, 0).isPlayer());
    }

    @Test
    public void testMakeMoveRight() {
        mazeState.makeMove(Direction.RIGHT);
        assertTrue(mazeState.getSquare(1, 6).isPlayer());
    }

    @Test
    public void testMakeMoveUp() {
        mazeState.makeMove(Direction.UP);
        assertTrue(mazeState.getSquare(1, 6).isPlayer());
    }

    @Test
    public void testIsSolved() {
        mazeState = new MazeState(new Position(1, 6), new Position(1, 6), TestMaze.TEST_MAZE);
        assertTrue(mazeState.isSolved());

        mazeState = new MazeState(new Position(1, 6), new Position(6, 6), TestMaze.TEST_MAZE);
        assertFalse(mazeState.isSolved());
    }

    @Test
    public void testGetLegalMoves() {
        mazeState = new MazeState(new Position(1, 6), new Position(6, 6), TestMaze.TEST_MAZE);

        Set<Direction> legalMoves = mazeState.getLegalMoves();
        assertTrue(legalMoves.contains(Direction.DOWN));
        assertFalse(legalMoves.contains(Direction.UP));
        assertFalse(legalMoves.contains(Direction.RIGHT));
    }

    @Test
    public void testClone() {
        MazeState clonedState = (MazeState) mazeState.clone();
        assertEquals(mazeState.toString(), clonedState.toString());
        assertNotSame(mazeState, clonedState);
    }

    @Test
    public void testToString() {
        String expectedOutput = """

                [O][O][O][O][O][O][O]
                [O][O][O][O][O][O][X]
                [O][O][O][O][O][O][O]
                [O][O][O][O][O][O][O]
                [O][O][O][O][O][O][O]
                [O][O][O][O][O][O][O]
                [O][O][O][O][O][O][O]
                """;
        assertEquals(expectedOutput, mazeState.toString());
    }
}
