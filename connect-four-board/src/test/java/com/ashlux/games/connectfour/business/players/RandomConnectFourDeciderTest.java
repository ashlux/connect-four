package com.ashlux.games.connectfour.business.players;

import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.ConnectFourBoardImpl;
import com.ashlux.games.connectfour.domain.GamePiece;
import com.ashlux.games.connectfour.domain.exception.ColumnFullException;
import com.ashlux.games.connectfour.business.players.RandomConnectFourPlayer;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;

public class RandomConnectFourDeciderTest
{
    @Test(timeOut = 2000)
    public void testDecide()
        throws ColumnFullException
    {
        // fill up all columns except the last one
        ConnectFourBoard connectFourBoard = new ConnectFourBoardImpl();
        for ( int x = 0; x < connectFourBoard.getNumberOfColumns() - 1; ++x )
        {
            for ( int y = 0; y < connectFourBoard.getNumberOfRows(); ++y )
            {
                connectFourBoard.putPiece( x, GamePiece.RED );
            }
        }

        RandomConnectFourPlayer randomConnectFourDecider = new RandomConnectFourPlayer();
        int column = randomConnectFourDecider.decide( connectFourBoard, GamePiece.RED );

        // last column should always be selected, eventually
        assertEquals( column, connectFourBoard.getNumberOfColumns() - 1 );
    }
}
