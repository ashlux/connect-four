package com.ashlux.games.connectfour.domain;

import com.ashlux.games.connectfour.domain.exception.ColumnFullException;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class ConnectFourBoardFactoryTest
{
    @Test
    public void testCreateEmptyBoard()
    {
        ConnectFourBoard connectFourBoard = ConnectFourBoardFactory.createEmptyBoard();

        // verify no column is full
        for ( int x = 0; x < connectFourBoard.getNumberOfColumns(); ++x )
        {
            assertFalse( connectFourBoard.isColumnFull( x ) );
        }

        // verify no pieces are placed on board
        for ( int x = 0; x < connectFourBoard.getNumberOfColumns(); ++x )
        {
            for ( int y = 0; y < connectFourBoard.getNumberOfRows(); ++y )
            {
                assertNull( connectFourBoard.getPieceAt( x, y ) );
            }
        }
    }

    @Test
    public void testCopyBoard()
        throws ColumnFullException
    {
        ConnectFourBoard fromConnectFourBoard = ConnectFourBoardFactory.createEmptyBoard();
        fromConnectFourBoard.putPiece( 4, GamePiece.RED );
        fromConnectFourBoard.putPiece( 5, GamePiece.BLACK );
        fromConnectFourBoard.putPiece( 4, GamePiece.RED );
        fromConnectFourBoard.putPiece( 5, GamePiece.BLACK );

        ConnectFourBoard toConnectFourBoard = ConnectFourBoardFactory.copyBoard( fromConnectFourBoard );

        assertNotNull( toConnectFourBoard );
        assertNotSame( toConnectFourBoard, fromConnectFourBoard );
        assertEquals( toConnectFourBoard.getNumberOfColumns(), fromConnectFourBoard.getNumberOfColumns() );
        assertEquals( toConnectFourBoard.getNumberOfRows(), fromConnectFourBoard.getNumberOfRows() );

        // verify pieces are the same
        for ( int x = 0; x < fromConnectFourBoard.getNumberOfColumns(); ++x )
        {
            for ( int y = 0; y < fromConnectFourBoard.getNumberOfRows(); ++y )
            {
                assertEquals( toConnectFourBoard.getPieceAt( x, y ), fromConnectFourBoard.getPieceAt( x, y ) );
            }
        }
    }
}
