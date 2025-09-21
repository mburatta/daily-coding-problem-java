package it.mburatta.ex002;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Knight's tour problem solver.
 */
public class KnightPathProblemResolver {

    private static final int[][] KNIGHT_MOVES = {
            { 2,  1}, { 1,  2},
            {-1,  2}, {-2,  1},
            {-2, -1}, {-1, -2},
            { 1, -2}, { 2, -1}
    };

    private final Cell startingPosition;
    private final int boardSize;

    /**
     * Creates a new instance of the solver.
     *
     * @param startingPosition The starting position of the knight.
     * @param boardSize The size of the board.
     */
    KnightPathProblemResolver(Cell startingPosition, int boardSize) {
        this.startingPosition = startingPosition;
        this.boardSize = boardSize;
    }

    /**
     * Solves the knight's tour problem.
     *
     * @return Empty list if no path exists, otherwise a list of cells representing the path.
     */
    public List<Cell> solve() {
        List<Cell> resultingKnightPath = extendPath(this.startingPosition, new ArrayList<>());
        return resultingKnightPath.size() <
                boardSize*boardSize ?
                new ArrayList<>() : resultingKnightPath;
    }

    /**
     * Extends the path by adding the next cell to the path.
     *
     * @param currentCell The next cell to add to the path.
     * @param pathSoFar The path so far.
     * @return The extended path.
     */
    public List<Cell> extendPath(Cell currentCell, List<Cell> pathSoFar) {

        List<Cell> explorePath = new ArrayList<>(pathSoFar);
        explorePath.add(currentCell);

        List<Cell> candidateMoves = this.findPossibleMoves(currentCell, explorePath);
        if(candidateMoves.isEmpty()){
            return explorePath;
        }

        return candidateMoves.stream()
                .map(nextCell -> this.extendPath(nextCell, explorePath))
                .max(Comparator.comparingInt(List::size))
                .orElseGet(ArrayList::new);

        /*
        List<Cell> bestContinuation = new ArrayList<>();
        for (Cell nextCell : candidateMoves) {
            List<Cell> candidatePath = this.extendPath(nextCell, explorePath);
            if (candidatePath.size() > bestContinuation.size()) {
                bestContinuation = candidatePath;
            }
        }
        return bestContinuation;
         */
    }

    /**
     * Finds the possible moves from the given cell.
     *
     * @param cell The cell to find the possible moves from.
     * @param partialPath The partial path so far.
     * @return A list of possible moves.
     */
    public List<Cell> findPossibleMoves(Cell cell, List<Cell> partialPath) {

        List<Cell> possibleMoves = new ArrayList<>();

        for (int[] move : KNIGHT_MOVES) {
            int dx = move[0];
            int dy = move[1];

            Cell next = new Cell(cell.getX() + dx, cell.getY() + dy);
            if (this.isMoveValid(next, partialPath)) {
                possibleMoves.add(next);
            }
        }

        return possibleMoves;
    }

    /**
     * Checks if the given cell is a valid move.
     *
     * @param cell The cell to check.
     * @param partialPath The partial path so far.
     * @return True if the cell is a valid move, false otherwise.
     */
    public boolean isMoveValid(Cell cell, List<Cell> partialPath) {
        return !partialPath.contains(cell)
                && cell.getX() >= 1 && cell.getX() <= this.boardSize
                && cell.getY() >= 1 && cell.getY() <= this.boardSize;
    }

}
