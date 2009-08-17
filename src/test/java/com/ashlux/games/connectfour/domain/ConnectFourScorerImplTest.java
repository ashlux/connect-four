package com.ashlux.games.connectfour.domain;

import com.ashlux.games.connectfour.domain.exception.ColumnFullException;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ConnectFourScorerImplTest
{
    private ConnectFourBoard connectFourBoard;

    private ConnectFourScorerImpl connectFourScorer;

    @BeforeMethod
    public void setup()
    {
        connectFourBoard = new ConnectFourBoardImpl();
        connectFourScorer = new ConnectFourScorerImpl();
    }

    @Test
    public void testEmptyBoard()
        throws Exception
    {
        buildBoardRow( connectFourBoard,
                       "-------",
                       "-------",
                       "-------",
                       "-------",
                       "-------",
                       "-------" );

        assertFalse(connectFourScorer.hasWinner( connectFourBoard ));
        assertNull(connectFourScorer.getWinner( connectFourBoard ));
    }

    @Test
    public void testDraw()
        throws Exception
    {
        buildBoardRow( connectFourBoard,
                       "RBRBRBR",
                       "RBRBRBR",
                       "BRBRBRB",
                       "BRBRBRB",
                       "RBRBRBR",
                       "RBRBRBR" );

        assertFalse(connectFourScorer.hasWinner( connectFourBoard ));
        assertNull(connectFourScorer.getWinner( connectFourBoard ));
    }

    @Test
    public void testRowWinning()
        throws Exception
    {
        buildBoardRow( connectFourBoard,
                       "-------",
                       "-------",
                       "-------",
                       "-------",
                       "-------",
                       "BBRRRRB" );

        assertTrue(connectFourScorer.hasWinner( connectFourBoard ));
        assertEquals(Player.RED, connectFourScorer.getWinner( connectFourBoard ));
    }

    @Test
    public void testRowWinning_leftEdge()
        throws Exception
    {
        buildBoardRow( connectFourBoard,
                       "-------",
                       "-------",
                       "-------",
                       "-------",
                       "-------",
                       "RRRRBBB" );

        assertTrue(connectFourScorer.hasWinner( connectFourBoard ));
        assertEquals(Player.RED, connectFourScorer.getWinner( connectFourBoard ));
    }

    @Test
    public void testRowWinning_rightEdge()
        throws Exception
    {
        buildBoardRow( connectFourBoard,
                       "-------",
                       "-------",
                       "-------",
                       "-------",
                       "-------",
                       "BBBRRRR" );

        assertTrue(connectFourScorer.hasWinner( connectFourBoard ));
        assertEquals(Player.RED, connectFourScorer.getWinner( connectFourBoard ));
    }

    @Test
    public void testColumnWinning_leftEdge()
        throws Exception
    {
        buildBoardRow( connectFourBoard,
                       "-------",
                       "-------",
                       "R------",
                       "RB-----",
                       "RB-----",
                       "RB-----" );

        assertTrue(connectFourScorer.hasWinner( connectFourBoard ));
        assertEquals(Player.RED, connectFourScorer.getWinner( connectFourBoard ));
    }

    @Test
    public void testColumnWinning_rightEdge()
        throws Exception
    {
        buildBoardRow( connectFourBoard,
                       "-------",
                       "-------",
                       "------R",
                       "-----BR",
                       "-----BR",
                       "-----BR" );

        assertTrue(connectFourScorer.hasWinner( connectFourBoard ));
        assertEquals(Player.RED, connectFourScorer.getWinner( connectFourBoard ));
    }


    @Test
    public void testColumnWinning_ForwardDiag()
        throws Exception
    {
        // Winner is oriented /
        buildBoardRow( connectFourBoard,
                       "-------",
                       "-------",
                       "---R---",
                       "--RR---",
                       "-RBB---",
                       "RBBRB--" );

        assertTrue(connectFourScorer.hasWinner( connectFourBoard ));
        assertEquals(Player.RED, connectFourScorer.getWinner( connectFourBoard ));
    }

    @Test
    public void testColumnWinning_BackwardDiag()
        throws Exception
    {
        // Winner is oriented \
        buildBoardRow( connectFourBoard,
                       "-------",
                       "-------",
                       "---R---",
                       "---BR--",
                       "---RBRB",
                       "---RBBR" );

        assertTrue(connectFourScorer.hasWinner( connectFourBoard ));
        assertEquals(Player.RED, connectFourScorer.getWinner( connectFourBoard ));
    }
    
    private void buildBoardRow( ConnectFourBoard connectFourBoard, String... rows )
        throws ColumnFullException
    {
        for ( int y = rows.length - 1; y >= 0; --y )
        {
            for ( int x = 0; x < rows[y].length(); ++x )
            {
                if ( rows[y].charAt( x ) == 'R' )
                {
                    connectFourBoard.putPiece( x, Player.RED );
                }
                else if ( rows[y].charAt( x ) == 'B' )
                {
                    connectFourBoard.putPiece( x, Player.BLACK );
                }
            }
        }
    }
}
