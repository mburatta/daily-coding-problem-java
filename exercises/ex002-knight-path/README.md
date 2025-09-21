# Knight Path (Knight's Tour)

Solve the Knight's Tour problem on an N×N chessboard: starting from a given cell, find a path where the knight visits each square exactly once.  
If a complete tour is not possible from the given start, return an empty path.

## Problem Description

- Board: N×N (N ≥ 1).
- Start: a given coordinate (x, y), 1-based.
- Move rules: standard chess knight moves (L-shape).
- Goal: return a sequence of cells representing a full knight’s tour (length N×N) if it exists; otherwise, return an empty list.

A “cell” is represented by coordinates (x, y), both within [1, N].

## API

- Solver class: `KnightPathProblemResolver`
    - Constructor: `KnightPathProblemResolver(Cell startingPosition, int boardSize)`
    - Method: `List<Cell> solve()`
        - Returns a list of `Cell` with size N×N if a full tour exists; otherwise, an empty list.

## Examples (from tests)

1) Path exists from (1,1) on 5×5:
- Input:
    - startingPosition = (1,1)
    - boardSize = 5
- Expected:
    - `solve()` returns a list of size 25 with no duplicates.

2) No path exists from (1,2) on 5×5:
- Input:
    - startingPosition = (1,2)
    - boardSize = 5
- Expected:
    - `solve()` returns an empty list (size 0) with no duplicates.

## How to run tests

From repository root:
