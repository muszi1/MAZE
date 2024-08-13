package game;

import modell.Direction;
import modell.MazeState;

import static solver.Main.MAZE;

/**
 * This class the manual-controller of the MazeState
 */
public class Main {

    public static void main(String[] args) {
        MazeState mazeState = new MazeState(MAZE);
        System.out.println(mazeState.toString());
        mazeState.makeMove(Direction.RIGHT);
        System.out.println(mazeState.toString());
    }

}
