package com.ashlux.games.connectfour.business.players;

import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.Player;

import java.util.Random;

public class RandomConnectFourPlayer
    implements ConnectFourPlayer
{
    public int decide( ConnectFourBoard connectFourBoard, Player computerPlayer )
    {
        Random random = new Random();
        int column;
        do
        {
            column = random.nextInt( connectFourBoard.getNumberOfColumns() );
        }
        while ( connectFourBoard.isColumnFull( column ) );
        return column;
    }

}
