package com.ashlux.games.connectfour.business;

import com.ashlux.games.connectfour.domain.ConnectFourBoard;

public interface ConnectFourDecider
{
    /**
     * Returns column to play - starting at zero.
     *
     * @param connectFourBoard connect four board to make decision based on
     * @return integer
     */
    int decide( final ConnectFourBoard connectFourBoard );
    
    String deciderName();
}
