package com.ashlux.games.connectfour.domain;

public class ConnectFourScorerImpl
    implements ConnectFourScorer
{

    public boolean hasWinner( ConnectFourBoard connectFourBoard )
    {
        return getWinner( connectFourBoard ) != null;

    }

    public Player getWinner( ConnectFourBoard connectFourBoard )
    {
        Player lastPlayerFound;
        int numberInARow;
        for ( int columnIndex = 0; columnIndex < connectFourBoard.getNumberOfColumns(); ++columnIndex )
        {
            // rest for new row
            lastPlayerFound = null;
            numberInARow = 1;

            for ( int rowIndex = 0; rowIndex < connectFourBoard.getNumberOfRows(); ++rowIndex )
            {
                Player currentPlayer = connectFourBoard.getPieceAt( columnIndex, rowIndex );
                if (currentPlayer != null && currentPlayer == lastPlayerFound )
                {
                    ++numberInARow;
                }
                else
                {
                    lastPlayerFound = currentPlayer;
                    numberInARow = 1;
                }

                if ( numberInARow == 4 )
                {
                    return lastPlayerFound;
                }
            }
        }

        return null;
    }
}
