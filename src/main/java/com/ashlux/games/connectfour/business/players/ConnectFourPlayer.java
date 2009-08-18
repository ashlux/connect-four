package com.ashlux.games.connectfour.business.players;

import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.Player;

public interface ConnectFourPlayer
{
    /**
     * Returns column to play - starting at zero. Called whenever it is the computer's
     * turn to make a decision.
     *
     * @param connectFourBoard connect four board to make decision based on
     * @param computerPlayer color the computer is playing
     * @return integer
     */
    int decide( final ConnectFourBoard connectFourBoard, final Player computerPlayer );
}
