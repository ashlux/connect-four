package com.ashlux.games.connectfour.business.deciders;

import com.ashlux.games.connectfour.business.ConnectFourScorerImplTest;
import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.ConnectFourBoardFactory;
import com.ashlux.games.connectfour.domain.Player;
import org.testng.annotations.Test;

public class ConnectFourSearchTreeDeciderTest
{
    @Test
    public void testDecide_emptyBoardPerformance()
        throws Exception
    {
        ConnectFourSearchTreeDecider connectFourSearchTreeDecider = new ConnectFourSearchTreeDecider();
            ConnectFourBoard connectFourBoard = ConnectFourBoardFactory.createEmptyBoard();
            ConnectFourScorerImplTest.buildBoardRow( connectFourBoard,
                       "-------",
                       "-------",
                       "-------",
                       "-------",
                       "-------",
                       "-------" );
            System.out.println(
                "FINAL CHOICE = " + connectFourSearchTreeDecider.decide( connectFourBoard, Player.RED ) );

    }
}
