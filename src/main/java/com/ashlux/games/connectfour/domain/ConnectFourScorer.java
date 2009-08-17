package com.ashlux.games.connectfour.domain;

public interface ConnectFourScorer
{
    boolean hasWinner(ConnectFourBoard connectFourBoard);

    Player getWinner(ConnectFourBoard connectFourBoard);
}
