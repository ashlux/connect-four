package com.ashlux.games.connectfour.business;

import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.Player;

public interface ConnectFourScorer
{
    /**
     * Game has a winner or there is a tie (board is full).
     *
     * @param connectFourBoard Board to check
     * @return Whether the game has a winner or there is a tie.
     */
    boolean isGameOver( final ConnectFourBoard connectFourBoard );

    /**
     *
     * @param connectFourBoard Board
     * @return True if the game has a winner, false if game is not over or there is a tie.
     */
    public boolean hasWinner( ConnectFourBoard connectFourBoard );

    /**
     * Who won the game?
     *
     * @param connectFourBoard Connect Four Board
     * @return Player enum or null if tie or no winner.
     */
    Player getWinner( final ConnectFourBoard connectFourBoard );
}
