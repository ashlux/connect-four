package com.ashlux.games.connectfour.domain;

import com.ashlux.games.connectfour.domain.exception.ColumnFullException;

public interface ConnectFourBoard
{
    /**
     * Get player at (X, Y).
     *
     * @param x X-Axis (between 0 and 6).
     * @param y Y-Axis (between 0 and 5).
     * @return Which player has a piece at (X, Y). Null if no player is at that location.
     * @throws IllegalArgumentException If x or y is invalid and outside the board.
     */
    GamePiece getPieceAt( int x, int y )
        throws IllegalArgumentException;


    /**
     * /**
     * Drop piece onto column X.
     *
     * @param x      Column to place player's piece (between 0 and 6).
     * @param gamePiece The player making a move.
     * @throws IllegalArgumentException If X is outside the board
     * @throws ColumnFullException      Too many pieces in column.
     */
    void putPiece( int x, GamePiece gamePiece )
        throws IllegalArgumentException, ColumnFullException;

    int getNumberOfRows();

    int getNumberOfColumns();

    boolean isColumnFull( int x );

    boolean isBoardFull();
}
