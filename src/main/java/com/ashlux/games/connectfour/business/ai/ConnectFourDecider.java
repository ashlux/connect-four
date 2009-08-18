package com.ashlux.games.connectfour.business.ai;

import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.Player;

public interface ConnectFourDecider
{
    /**
     * Returns column to play - starting at zero.
     *
     * @param connectFourBoard connect four board to make decision based on
     * @param computerPlayer color the computer is playing
     * @return integer
     */
    int decide( final ConnectFourBoard connectFourBoard, final Player computerPlayer );
    
    String deciderName();
}
