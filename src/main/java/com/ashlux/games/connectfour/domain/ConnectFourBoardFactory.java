package com.ashlux.games.connectfour.domain;

import com.ashlux.games.connectfour.domain.exception.ColumnFullException;
import com.ashlux.games.connectfour.domain.exception.ConnectFourRuntimeException;

public class ConnectFourBoardFactory
{
    private ConnectFourBoardFactory()
    {
    }

    public static ConnectFourBoard createEmptyBoard()
    {
        return new ConnectFourBoardImpl();
    }

    public static ConnectFourBoard copyBoard( ConnectFourBoard fromBoard )
    {
        try
        {
            return copy( fromBoard );
        }
        catch ( ColumnFullException e )
        {
            // shouldn't happen, so runtime exception
            throw new ConnectFourRuntimeException();
        }
    }

    private static ConnectFourBoard copy(ConnectFourBoard fromBoard)
        throws ColumnFullException
    {
        ConnectFourBoard toBoard = new ConnectFourBoardImpl();
        for ( int x = 0; x < fromBoard.getNumberOfColumns(); ++x )
        {
            for ( int y = 0; y < fromBoard.getNumberOfRows(); ++y )
            {
                GamePiece pieceAtXY = fromBoard.getPieceAt( x, y );
                if (pieceAtXY != null) {
                    toBoard.putPiece( x, fromBoard.getPieceAt( x, y ) );
                }
            }
        }
        return toBoard;
    }
}
