package com.ashlux.games.connectfour.business;

import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.Player;

public interface ConnectFourScorer
{
    boolean hasWinner( final ConnectFourBoard connectFourBoard );

    Player getWinner( final ConnectFourBoard connectFourBoard );
}
