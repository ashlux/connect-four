package com.ashlux.games.connectfour.domain;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertEquals;
import com.sun.javaws.exceptions.InvalidArgumentException;
import com.ashlux.games.connectfour.domain.exception.ColumnFullException;

public class ConnectFourBoardImplTest
{
    private ConnectFourBoardImpl connectFourBoard;

    @BeforeTest()
    public void setup()
    {
        connectFourBoard = new ConnectFourBoardImpl();
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetPieceAt_negativeColumn_invalid()
        throws InvalidArgumentException
    {
        connectFourBoard.getPieceAt( -1, 0 );
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetPieceAt_columnTooBig_invalid()
        throws InvalidArgumentException
    {
        connectFourBoard.getPieceAt( 7, 0 );
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetPieceAt_negativeRow_invalid()
        throws InvalidArgumentException
    {
        connectFourBoard.getPieceAt( 0, -1 );
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testGetPieceAt_rowTooBig_invalid()
        throws InvalidArgumentException
    {
        connectFourBoard.getPieceAt( 0, 6 );
    }

    @Test
    public void testGetPieceAt_noPieceFound()
        throws InvalidArgumentException
    {
        assertNull( connectFourBoard.getPieceAt( 0, 0 ) );
    }

    @Test
    public void testGetPieceAt_pieceFound()
        throws InvalidArgumentException, ColumnFullException
    {
        connectFourBoard.getColumns().get( 0 ).add( Player.RED );
        assertEquals( Player.RED, connectFourBoard.getPieceAt( 0, 0 ) );
    }

    @Test(expectedExceptions = InvalidArgumentException.class)
    public void testPutPiece_negativeColumn_invalid()
        throws ColumnFullException, InvalidArgumentException
    {
        connectFourBoard.putPiece( -1, Player.RED );
    }

    @Test(expectedExceptions = InvalidArgumentException.class)
    public void testPutPiece_columnTooBig_invalid()
        throws ColumnFullException, InvalidArgumentException
    {
        connectFourBoard.putPiece( 7, Player.RED );
    }

    @Test(expectedExceptions = ColumnFullException.class)
    public void testPutPiece_columnTooFull()
        throws ColumnFullException, InvalidArgumentException
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
        throws InvalidArgumentException, ColumnFullException
    {
        connectFourBoard.putPiece( 0, Player.RED );
        assertEquals( Player.RED, connectFourBoard.getColumns().get( 0 ).get( 0 ) );
    }
}
