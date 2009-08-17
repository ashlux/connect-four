package com.ashlux.games.connectfour.domain;

import com.ashlux.games.connectfour.domain.exception.ColumnFullException;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ConnectFourBoardImplTest
{
    private ConnectFourBoardImpl connectFourBoard;

    @BeforeMethod()
    public void setup()
    {
        connectFourBoard = new ConnectFourBoardImpl();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetPieceAt_negativeColumn_invalid()
        throws IllegalArgumentException
    {
        connectFourBoard.getPieceAt( -1, 0 );
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetPieceAt_columnTooBig_invalid()
        throws IllegalArgumentException
    {
        connectFourBoard.getPieceAt( 7, 0 );
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetPieceAt_negativeRow_invalid()
        throws IllegalArgumentException
    {
        connectFourBoard.getPieceAt( 0, -1 );
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetPieceAt_rowTooBig_invalid()
        throws IllegalArgumentException
    {
        connectFourBoard.getPieceAt( 0, 6 );
    }

    @Test
    public void testGetPieceAt_noPieceFound()
        throws IllegalArgumentException
    {
        assertNull( connectFourBoard.getPieceAt( 0, 0 ) );
    }

    @Test
    public void testGetPieceAt_pieceFound()
        throws IllegalArgumentException, ColumnFullException
    {
        connectFourBoard.getColumns().get( 0 ).add( Player.RED );
        assertEquals( Player.RED, connectFourBoard.getPieceAt( 0, 0 ) );
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testPutPiece_negativeColumn_invalid()
        throws ColumnFullException, IllegalArgumentException
    {
        connectFourBoard.putPiece( -1, Player.RED );
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testPutPiece_columnTooBig_invalid()
        throws ColumnFullException, IllegalArgumentException
    {
        connectFourBoard.putPiece( 7, Player.RED );
    }

    @Test(expectedExceptions = ColumnFullException.class)
    public void testPutPiece_columnTooFull()
        throws ColumnFullException, IllegalArgumentException
    {
        connectFourBoard.getColumns().get( 0 ).add( Player.RED );
        connectFourBoard.getColumns().get( 0 ).add( Player.RED );
        connectFourBoard.getColumns().get( 0 ).add( Player.RED );
        connectFourBoard.getColumns().get( 0 ).add( Player.RED );
        connectFourBoard.getColumns().get( 0 ).add( Player.RED );
        connectFourBoard.getColumns().get( 0 ).add( Player.RED );
        connectFourBoard.putPiece( 0, Player.RED );
    }

    @Test
    public void testPutPiece()
        throws IllegalArgumentException, ColumnFullException
    {
        connectFourBoard.putPiece( 0, Player.RED );
        assertEquals( Player.RED, connectFourBoard.getColumns().get( 0 ).get( 0 ) );
    }
}
