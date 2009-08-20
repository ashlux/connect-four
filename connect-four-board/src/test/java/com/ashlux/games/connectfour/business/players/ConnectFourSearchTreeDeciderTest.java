package com.ashlux.games.connectfour.business.players;

import com.ashlux.games.connectfour.business.play.ConnectFourScorerImplTest;
import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.ConnectFourBoardFactory;
import com.ashlux.games.connectfour.domain.GamePiece;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class ConnectFourSearchTreeDeciderTest
{
    @Test
    public void testDecide_emptyBoardPerformance()
        throws Exception
    {
        ConnectFourSearchTreePlayer connectFourSearchTreeDecider = new ConnectFourSearchTreePlayer();
        ConnectFourBoard connectFourBoard = ConnectFourBoardFactory.createEmptyBoard();
        ConnectFourScorerImplTest.buildBoardRow( connectFourBoard,
                       "RRR--BB",
                       "BRBRBRB",
                       "RBRBRBR",
                       "RBRBRBR",
                       "BRBRBRB",
                       "BRBRBRB" );

        assertEquals( connectFourSearchTreeDecider.decide( connectFourBoard, GamePiece.RED ), 3 );
    }
}
