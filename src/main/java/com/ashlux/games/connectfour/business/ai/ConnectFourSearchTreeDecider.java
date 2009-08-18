package com.ashlux.games.connectfour.business.ai;

import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.Player;
import com.ashlux.games.connectfour.business.ConnectFourScorer;
import com.ashlux.games.connectfour.business.ConnectFourScorerImpl;

public class ConnectFourSearchTreeDecider
    implements ConnectFourDecider
{
    public static final String NAME = "Search Tree";

    public static final int WIN_VALUE = 1;

    public static final int DRAW_VALUE = 0;

    public static final int LOSE_VALUE = -1;

    private ConnectFourScorer connectFourScorer = new ConnectFourScorerImpl();

    public int decide( ConnectFourBoard connectFourBoard, Player computerPlayer )
    {
        int resultColumn0 = tryColumn( 0, connectFourBoard, computerPlayer, computerPlayer );
        int resultColumn1 = tryColumn( 1, connectFourBoard, computerPlayer, computerPlayer );
        int resultColumn2 = tryColumn( 2, connectFourBoard, computerPlayer, computerPlayer );
        int resultColumn3 = tryColumn( 3, connectFourBoard, computerPlayer, computerPlayer );
        int resultColumn4 = tryColumn( 4, connectFourBoard, computerPlayer, computerPlayer );
        int resultColumn5 = tryColumn( 5, connectFourBoard, computerPlayer, computerPlayer );
        int resultColumn6 = tryColumn( 6, connectFourBoard, computerPlayer, computerPlayer );

        return 0;
    }

    private int tryColumn( int columnIndex, ConnectFourBoard connectFourBoard, Player computerPlayer,
                           Player currentTurn )
    {
        if ( connectFourScorer.isGameOver( connectFourBoard ) )
        {
            Player winner = connectFourScorer.getWinner( connectFourBoard );
            if ( winner == computerPlayer )
            {
                return WIN_VALUE;
            }
            else if ( winner == null )
            {
                return DRAW_VALUE;
            }
            else
            {
                return LOSE_VALUE;
            }
        }

//        connectFourBoard.

        return 0;
    }


    public String deciderName()
    {
        return NAME;
    }
}
