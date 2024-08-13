package modell;

import puzzle.State;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

/**
 *  This class contains the basic logic for the Maze game.
 */
public class MazeState implements State<Direction> {
    public static final int BOARD_SIZE_WIDTH = 7;
    public static final int BOARD_SIZE_HEIGTH = 7;
    private final Square[][] table;
    private Position finishPosition;
    private Position ballballPosition;

    public MazeState(Square[][] table) {
        this.table = new Square[BOARD_SIZE_HEIGTH][BOARD_SIZE_WIDTH];
        for (int i = 0; i < BOARD_SIZE_HEIGTH; i++) {
            for (int j = 0; j < BOARD_SIZE_WIDTH; j++) {
                this.table[i][j] = new Square(
                        table[i][j].getPosition(),
                        table[i][j].getWalls(),
                        table[i][j].isPlayer(),
                        table[i][j].isFinish()
                );
                if (table[i][j].isPlayer())
                {
                    ballballPosition =table[i][j].getPosition();
                }
                if (table[i][j].isFinish())
                {
                    finishPosition=table[i][j].getPosition();
                }
            }
        }
    }
    public MazeState(Position ballballPosition, Position finishPosition, Square[][] table){
        this.finishPosition = finishPosition;
        this.ballballPosition = ballballPosition;
        this.table = table;
    }

    /**
     * Returns the Square's rows and cols
     * @param row Describes the row index parameter.
     * @param col Describes the col index parameter.
     * @return Returns the square position in the Maze.
     */
    public Square getSquare(int row, int col) {
        return table[row][col];
    }

    /**
     * Checks if the current position of the ball matches the finish position.
     * @return Return the ball is at the finish position or not.
     */
    @Override
    public boolean isSolved() {
        return ballballPosition.equals(finishPosition);
    }

    /**
     * Checks if a move in the specified direction is legal based on the current position of the ball.
     * @param direction  Describes the parameter that specifies the direction of the move.
     * @return The move in the specified direction is legal or not.
     */
    @Override
    public boolean isLegalMove(Direction direction) {
        switch (direction) {
            case UP -> {
                    if (Arrays.asList(table[ballballPosition.row()][ballballPosition.col()].getWalls()).contains(Wall.TOP)){
                        return false;
                    }

                    return true;
                }
            case RIGHT -> {
                if (Arrays.asList(table[ballballPosition.row()][ballballPosition.col()].getWalls()).contains(Wall.RIGHT)){
                    return false;
                }
                    return true;
            }
            case DOWN -> {
                if (Arrays.asList(table[ballballPosition.row()][ballballPosition.col()].getWalls()).contains(Wall.BOTTOM)) {
                    return false;
                }
                    return true;
            }
            case LEFT -> {
                if (Arrays.asList(table[ballballPosition.row()][ballballPosition.col()].getWalls()).contains(Wall.LEFT)) {
                    return false;
                }
                    return true;
            }
        }
        return false;
    }

    /**
     * Moves the ball in the specified direction until it can no longer move legally.
     * @param direction Describes the parameter that specifies the direction of the move.
     */
    @Override
    public void makeMove(Direction direction) {
            switch (direction){
                case UP -> {
                    while(isLegalMove(direction)){
                        table[ballballPosition.row()-1][ballballPosition.col()].setPlayer(true);
                        table[ballballPosition.row()][ballballPosition.col()].setPlayer(false);
                        ballballPosition =new Position(ballballPosition.row()-1, ballballPosition.col());
                    }
                }
                case RIGHT -> {
                    while(isLegalMove(direction)){
                        table[ballballPosition.row()][ballballPosition.col()+1].setPlayer(true);
                        table[ballballPosition.row()][ballballPosition.col()].setPlayer(false);
                        ballballPosition =new Position(ballballPosition.row(), ballballPosition.col()+1);
                    }
                }
                case DOWN -> {
                    while(isLegalMove(direction)){
                        table[ballballPosition.row()+1][ballballPosition.col()].setPlayer(true);
                        table[ballballPosition.row()][ballballPosition.col()].setPlayer(false);
                        ballballPosition =new Position(ballballPosition.row()+1, ballballPosition.col());
                    }
                }
                case LEFT -> {
                    while(isLegalMove(direction)){
                        table[ballballPosition.row()][ballballPosition.col()-1].setPlayer(true);
                        table[ballballPosition.row()][ballballPosition.col()].setPlayer(false);
                        ballballPosition =new Position(ballballPosition.row(), ballballPosition.col()-1);
                    }
                }
            }
    }

    /**
     * Retrieves The set of legal moves that can be made from the current position of the ball.
     * @return A set representing the legal moves. If no legal moves are available, the set will be empty.
     */
    @Override
    public Set<Direction> getLegalMoves() {
        var legalmoves= EnumSet.noneOf(Direction.class);
       for (var direction:Direction.values()){
            if (isLegalMove(direction)){
                legalmoves.add(direction);
            }
       }
        return legalmoves;
    }

    /**
     * Creates a deep copy of the current MazeState object.
     * @return Returns a new State object that is a deep copy of the current MazeState.
     */
    @Override
    public State<Direction> clone() {
        var ballPositionCopy = new Position(this.ballballPosition.row(), this.ballballPosition.col());
        var finishPositionCopy = new Position(this.finishPosition.row(), this.finishPosition.col());

        return new MazeState(ballPositionCopy, finishPositionCopy, this.copyTable());
    }

    @Override
    public String toString() {
        StringBuilder tableOutput = new StringBuilder("\n");
        for (int i = 0; i < BOARD_SIZE_HEIGTH; i++) {
            for (int j = 0; j < BOARD_SIZE_WIDTH; j++) {
                if (table[i][j].isPlayer()){
                    tableOutput.append("[X]");
                }
                else{
                    tableOutput.append("[O]");
                }
            }
            tableOutput.append("\n");
        }
        return tableOutput.toString();
    }

    private Square[][] copyTable() {
        Square [][] tableCopy = new Square[BOARD_SIZE_HEIGTH][BOARD_SIZE_WIDTH];
        for(int i = 0; i < BOARD_SIZE_HEIGTH; i++) {
            for (int j = 0; j < BOARD_SIZE_WIDTH; j++) {
                tableCopy[i][j] = new Square(
                        table[i][j].getPosition(),
                        table[i][j].getWalls(),
                        table[i][j].isPlayer(),
                        table[i][j].isFinish()
                );
            }
        }
        return tableCopy;
    }
}
