package com.ashlux.games.connectfour.domain;

import com.sun.javaws.exceptions.InvalidArgumentException;
import com.sun.istack.internal.NotNull;
import com.ashlux.games.connectfour.domain.exception.ColumnFullException;

public interface ConnectFourBoard
{
    /**
     * Get player at (X, Y).
     *
     * @param x X-Axis (between 0 and 6).
     * @param y Y-Axis (between 0 and 5).
     * @throws com.sun.javaws.exceptions.InvalidArgumentException If x or y is invalid and outside the board.
     * @return Which player has a piece at (X, Y). Null if no player is at that location.
     */
    Player getPieceAt(int x, int y) throws InvalidArgumentException;


    /**
  /**
     * Drop piece onto column X.
     *
     * @param x Column to place player's piece (between 0 and 6).
     * @param player The player making a move.
     * @throws InvalidArgumentException If X is outside the board
     * @throws ColumnFullException Too many pieces in column.
     */
    void putPiece(int x, @NotNull Player player) throws InvalidArgumentException, ColumnFullException;
}
