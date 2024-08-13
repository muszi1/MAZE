package modell;

/**
 * This record class represents the squares positions in the Maze.
 * @param row This variable means the height of square's.
 * @param col This variable means the width of square's.
 */
public record Position(int row,int col) {

    @Override
    public String toString() {

        return String.format("(%d,%d)",row,col);
    }
}
