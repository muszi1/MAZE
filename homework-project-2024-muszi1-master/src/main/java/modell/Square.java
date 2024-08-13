package modell;

import java.util.Arrays;
import java.util.Objects;

/**
 * This class describe the square,player and the finish details
 */
public class Square {
    Position position;
    Wall[] walls;
    private boolean isPlayer;
    private boolean isFinish;

    /**
     *  Retrieves the current position.
     * @return Returns the positions of the square
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Retrieves the array of walls surrounding the current position.
     * @return Returns the Wall's type.
     */
    public Wall[] getWalls() {
        return walls;
    }

    /**
     * Checks if the current position is occupied by the player.
     * @return Returns with boolean indicating whether the current position is occupied by the player.
     */
    public boolean isPlayer() {
        return isPlayer;
    }

    /**
     * Checks if the current position is the finish
     * @return Returns boolean indicating whether the current position is the finish position.
     */
    public boolean isFinish() {
        return isFinish;
    }

    public Square(Position position, Wall[] walls, boolean isPlayer, boolean isFinish) {
        this.position = position;
        this.walls = walls;
        this.isPlayer = isPlayer;
        this.isFinish = isFinish;
    }

    /**
     * Sets whether the current position is occupied by the player.
     * @param player Returns whether the position is occupied by the player.
     */
    public void setPlayer(boolean player) {
        isPlayer = player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        if (isPlayer != square.isPlayer) return false;
        if (isFinish != square.isFinish) return false;
        if (!Objects.equals(position, square.position)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(walls, square.walls);
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(walls);
        result = 31 * result + (isPlayer ? 1 : 0);
        result = 31 * result + (isFinish ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Square{");
        sb.append("position=").append(position);
        sb.append(", walls=").append(Arrays.toString(walls));
        sb.append(", isPlayer=").append(isPlayer);
        sb.append(", isFinish=").append(isFinish);
        sb.append('}');
        return sb.toString();
    }
}
