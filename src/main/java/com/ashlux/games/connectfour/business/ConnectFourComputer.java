package com.ashlux.games.connectfour.business;

import com.ashlux.games.connectfour.domain.ConnectFourBoard;

public interface ConnectFourComputer
{
    int playInWhichColumn( final ConnectFourBoard connectFourBoard );
}
