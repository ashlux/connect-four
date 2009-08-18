package com.ashlux.games.connectfour.business.play;

import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.Player;

public class ConnectFourScorerImpl
    implements ConnectFourScorer
{

    public boolean isGameOver( final ConnectFourBoard connectFourBoard )
    {
        // have a winner OR board is full (draw)
        return hasWinner( connectFourBoard ) || connectFourBoard.isBoardFull();
    }

    public boolean hasWinner( ConnectFourBoard connectFourBoard )
    {
        return getWinner( connectFourBoard ) != null;
    }

    public Player getWinner( ConnectFourBoard connectFourBoard )
    {
        for ( int x = 0; x < connectFourBoard.getNumberOfColumns(); ++x )
        {
            for ( int y = 0; y < connectFourBoard.getNumberOfRows(); ++y )
            {
                Player winningPlayer = winnerAtPointStartOfAWinningSolution( connectFourBoard, x, y );
                if ( winningPlayer != null )
                {
                    return winningPlayer;
                }
            }
        }
        return null;
    }

    private Player winnerAtPointStartOfAWinningSolution( final ConnectFourBoard connectFourBoard, int x, int y )
    {
        Player testPiece = connectFourBoard.getPieceAt( x, y );

        if ( testPiece == null )
        {
            return null;
        }

        // check row
        if ( x + 3 < connectFourBoard.getNumberOfColumns() && connectFourBoard.getPieceAt( x + 1, y ) == testPiece &&
            connectFourBoard.getPieceAt( x + 2, y ) == testPiece &&
            connectFourBoard.getPieceAt( x + 3, y ) == testPiece )
        {
            return testPiece;
        }

        // check column
        if ( y + 3 < connectFourBoard.getNumberOfRows() && connectFourBoard.getPieceAt( x, y + 1 ) == testPiece &&
            connectFourBoard.getPieceAt( x, y + 2 ) == testPiece &&
            connectFourBoard.getPieceAt( x, y + 3 ) == testPiece )
        {
            return testPiece;
        }

        // check forward diag /
        if ( x + 3 < connectFourBoard.getNumberOfColumns() && y + 3 < connectFourBoard.getNumberOfRows() &&
            connectFourBoard.getPieceAt( x + 1, y + 1 ) == testPiece &&
            connectFourBoard.getPieceAt( x + 2, y + 2 ) == testPiece &&
            connectFourBoard.getPieceAt( x + 3, y + 3 ) == testPiece )
        {
            return testPiece;
        }

        // check backward diag \
        if ( x + 3 < connectFourBoard.getNumberOfColumns() && y - 3 >= 0 &&
            connectFourBoard.getPieceAt( x + 1, y - 1 ) == testPiece &&
            connectFourBoard.getPieceAt( x + 2, y - 2 ) == testPiece &&
            connectFourBoard.getPieceAt( x + 3, y - 3 ) == testPiece )
        {
            return testPiece;
        }

        return null;
    }
}
