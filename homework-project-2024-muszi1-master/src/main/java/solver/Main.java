package solver;

import modell.*;
import puzzle.solver.BreadthFirstSearch;

/**
 * This class contains the BreadthFirstSearch to solve the game.
 */
public class Main {
    public static void main(String[] args) {
        var bfs = new BreadthFirstSearch<Direction>();
        bfs.solveAndPrintSolution(new MazeState(MAZE));
    }

    public static final Square[][] MAZE =  {
            {
                    new Square(new Position(0, 0), new Wall[]{Wall.RIGHT, Wall.TOP, Wall.LEFT}, false, false),
                    new Square(new Position(0, 1), new Wall[]{Wall.TOP, Wall.LEFT}, false, false),
                    new Square(new Position(0, 2), new Wall[]{Wall.TOP, Wall.BOTTOM}, false, false),
                    new Square(new Position(0, 3), new Wall[]{Wall.TOP, Wall.RIGHT}, false, false),
                    new Square(new Position(0, 4), new Wall[]{Wall.TOP,Wall.LEFT}, false, false),
                    new Square(new Position(0, 5), new Wall[]{Wall.TOP}, false, false),
                    new Square(new Position(0, 6), new Wall[]{Wall.TOP, Wall.RIGHT, Wall.BOTTOM}, false, false)},

            {
                    new Square(new Position(1, 0), new Wall[]{Wall.LEFT}, false, false),
                    new Square(new Position(1, 1), new Wall[]{}, false, false),
                    new Square(new Position(1, 2), new Wall[]{Wall.TOP}, false, false),
                    new Square(new Position(1, 3), new Wall[]{}, false, false),
                    new Square(new Position(1, 4), new Wall[]{}, true, false),
                    new Square(new Position(1, 5), new Wall[]{}, false, false),
                    new Square(new Position(1, 6), new Wall[]{Wall.TOP,Wall.RIGHT}, false, false)},

            {
                    new Square(new Position(2, 0), new Wall[]{Wall.LEFT}, false, false),
                    new Square(new Position(2, 1), new Wall[]{Wall.BOTTOM}, false, false),
                    new Square(new Position(2, 2), new Wall[]{Wall.RIGHT}, false, false),
                    new Square(new Position(2, 3), new Wall[]{Wall.LEFT}, false, false),
                    new Square(new Position(2, 4), new Wall[]{}, false, false),
                    new Square(new Position(2, 5), new Wall[]{Wall.RIGHT}, false, false),
                    new Square(new Position(2, 6), new Wall[]{Wall.LEFT, Wall.RIGHT}, false, false)},

            {
                    new Square(new Position(3, 0), new Wall[]{Wall.LEFT}, false, false),
                    new Square(new Position(3, 1), new Wall[]{Wall.TOP}, false, false),
                    new Square(new Position(3, 2), new Wall[]{}, false, false),
                    new Square(new Position(3, 3), new Wall[]{Wall.BOTTOM,Wall.RIGHT}, false, false),
                    new Square(new Position(3, 4), new Wall[]{Wall.RIGHT, Wall.LEFT}, false, false),
                    new Square(new Position(3, 5), new Wall[]{Wall.LEFT}, false, false),
                    new Square(new Position(3, 6), new Wall[]{Wall.BOTTOM, Wall.RIGHT}, false, false)},

            {
                    new Square(new Position(4, 0), new Wall[]{Wall.BOTTOM, Wall.LEFT}, false, false),
                    new Square(new Position(4, 1), new Wall[]{}, false, false),
                    new Square(new Position(4, 2), new Wall[]{}, false, false),
                    new Square(new Position(4, 3), new Wall[]{Wall.TOP}, false, false),
                    new Square(new Position(4, 4), new Wall[]{Wall.BOTTOM}, false, false),
                    new Square(new Position(4, 5), new Wall[]{}, false, false),
                    new Square(new Position(4, 6), new Wall[]{Wall.TOP,Wall.RIGHT}, false, false)},

            {
                    new Square(new Position(5, 0), new Wall[]{Wall.TOP,Wall.LEFT}, false, false),
                    new Square(new Position(5, 1), new Wall[]{Wall.RIGHT}, false, false),
                    new Square(new Position(5, 2), new Wall[]{Wall.RIGHT, Wall.LEFT,Wall.BOTTOM}, false, true),
                    new Square(new Position(5, 3), new Wall[]{ Wall.LEFT}, false, false),
                    new Square(new Position(5, 4), new Wall[]{Wall.TOP}, false, false),
                    new Square(new Position(5, 5), new Wall[]{}, false, false),
                    new Square(new Position(5, 6), new Wall[]{Wall.RIGHT}, false, false)},

            {
                    new Square(new Position(6, 0), new Wall[]{Wall.LEFT,Wall.BOTTOM}, false, false),
                    new Square(new Position(6, 1), new Wall[]{Wall.BOTTOM}, false, false),
                    new Square(new Position(6, 2), new Wall[]{Wall.TOP,Wall.BOTTOM}, false, false),
                    new Square(new Position(6, 3), new Wall[]{Wall.RIGHT, Wall.BOTTOM}, false, false),
                    new Square(new Position(6, 4), new Wall[]{Wall.LEFT,Wall.BOTTOM}, false, false),
                    new Square(new Position(6, 5), new Wall[]{Wall.BOTTOM, Wall.RIGHT}, false, false),
                    new Square(new Position(6, 6), new Wall[]{Wall.RIGHT,Wall.BOTTOM,Wall.LEFT}, false, false)}};
}
