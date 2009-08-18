package com.ashlux.games.connectfour.business.deciders;

import com.ashlux.games.connectfour.business.play.ConnectFourScorer;
import com.ashlux.games.connectfour.business.play.ConnectFourScorerImpl;
import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.ConnectFourBoardFactory;
import com.ashlux.games.connectfour.domain.Player;
import com.ashlux.games.connectfour.domain.exception.ColumnFullException;
import com.ashlux.games.connectfour.domain.exception.ConnectFourRuntimeException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ConnectFourSearchTreeDecider
    implements ConnectFourDecider
{
    public static final String NAME = "Search Tree";

    public static final int WIN_VALUE = 1;

    public static final int DRAW_VALUE = 0;

    public static final int LOSE_VALUE = -1;

    public long count = 0;

    private ConnectFourScorer connectFourScorer = new ConnectFourScorerImpl();

    public int decide( ConnectFourBoard connectFourBoard, Player computerPlayer )
    {
        List<PathChoice> pathChoices = new LinkedList<PathChoice>();
        for ( int x = 0; x < connectFourBoard.getNumberOfColumns(); ++x )
        {
            if ( !connectFourBoard.isColumnFull( x ) )
            {
                System.out.println( "Column = " + x );
                System.out.println( "Recursion Count (Before) = " + count );
                PathChoice pathChoice = new PathChoice();
                pathChoice.setColumn( x );
                // current turn is computer since decide is called only on computer's turn
                pathChoice.setValue( tryColumn( x, connectFourBoard, computerPlayer, computerPlayer ) );
                pathChoices.add( pathChoice );
                System.out.println( "Recursion Count (After)  = " + count );
                System.out.println( "Path choice value for column [" + x + "] = " + pathChoice.getValue() );
            }
        }

        Collections.sort( pathChoices );

        return pathChoices.get( 0 ).getColumn();
    }

    private int tryColumn( int columnIndex, final ConnectFourBoard connectFourBoard, Player computerPlayer,
                           Player currentTurn )
    {
        ++count;

        ConnectFourBoard newConnectFourBoard = ConnectFourBoardFactory.copyBoard( connectFourBoard );
        try
        {
            newConnectFourBoard.putPiece( columnIndex, currentTurn );
        }
        catch ( ColumnFullException e )
        {
            // column should not be full
            throw new ConnectFourRuntimeException();
        }


        if ( connectFourScorer.isGameOver( newConnectFourBoard ) )
        {
            return getGameOverResult( newConnectFourBoard, computerPlayer );
        }

        int result = 0;
        for ( int x = 0; x < newConnectFourBoard.getNumberOfColumns(); ++x )
        {
            if ( !newConnectFourBoard.isColumnFull( x ) )
            {
                result += tryColumn( x, newConnectFourBoard, computerPlayer, getNextTurn( currentTurn ) );
            }
        }
        return result;
    }

    private Player getNextTurn( Player currentTurn )
    {
        if ( currentTurn == Player.RED )
        {
            return Player.BLACK;
        }
        else
        {
            return Player.RED;
        }
    }

    private int getGameOverResult( ConnectFourBoard connectFourBoard, Player computerPlayer )
    {
        Player winner = connectFourScorer.getWinner( connectFourBoard );
//        System.out.println("WINNER (null=TIE): " + winner);
        if ( winner == computerPlayer )
        {
            return WIN_VALUE;
        }
        else if ( winner == null )
        {
            return DRAW_VALUE;
        }
        else
        {
            return LOSE_VALUE;
        }
    }

    public String deciderName()
    {
        return NAME;
    }

    private class PathChoice
        implements Comparable
    {
        private int column;

        private int value;

        public int getColumn()
        {
            return column;
        }

        public void setColumn( int column )
        {
            this.column = column;
        }

        public int getValue()
        {
            return value;
        }

        public void setValue( int value )
        {
            this.value = value;
        }

        public int compareTo( Object o )
        {
            PathChoice pathChoice2 = (PathChoice) o;

            return new Integer( value ).compareTo( pathChoice2.value );
        }
    }
}
