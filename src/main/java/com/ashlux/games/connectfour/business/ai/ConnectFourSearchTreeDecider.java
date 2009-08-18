package com.ashlux.games.connectfour.business.ai;

import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.Player;

public class ConnectFourSearchTreeDecider
    implements ConnectFourDecider
{
    public static final String NAME = "Search Tree";

    public static final int WIN_VALUE = 1;

    public static final int DRAW_VALUE = 0;

    public static final int LOSE_VALUE = -1;

    public int decide( ConnectFourBoard connectFourBoard, Player computerPlayer )
    {
        int resultColumn0 = tryColumn( 0, connectFourBoard, computerPlayer );
        int resultColumn1 = tryColumn( 1, connectFourBoard, computerPlayer );
        int resultColumn2 = tryColumn( 2, connectFourBoard, computerPlayer );
        int resultColumn3 = tryColumn( 3, connectFourBoard, computerPlayer );
        int resultColumn4 = tryColumn( 4, connectFourBoard, computerPlayer );
        int resultColumn5 = tryColumn( 5, connectFourBoard, computerPlayer );
        int resultColumn6 = tryColumn( 6, connectFourBoard, computerPlayer );

        return 0;
    }

    private int tryColumn( int i, ConnectFourBoard connectFourBoard, Player computerPlayer )
    {
//        connectFourBoard.
        return 0;
    }


    public String deciderName()
    {
        return NAME;
    }
}
