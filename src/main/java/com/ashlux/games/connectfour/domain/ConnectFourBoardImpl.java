package com.ashlux.games.connectfour.domain;

import com.ashlux.games.connectfour.domain.exception.ColumnFullException;

import java.util.List;
import java.util.LinkedList;

public class ConnectFourBoardImpl
    implements ConnectFourBoard
{
    public static final int MAX_ROWS = 6;

    public static final int MAX_COLUMNS = 7;

    private List<List<Player>> columns;

    public ConnectFourBoardImpl()
    {
        columns = new LinkedList<List<Player>>();
        columns.add( new LinkedList<Player>() );
        columns.add( new LinkedList<Player>() );
        columns.add( new LinkedList<Player>() );
        columns.add( new LinkedList<Player>() );
        columns.add( new LinkedList<Player>() );
        columns.add( new LinkedList<Player>() );
        columns.add( new LinkedList<Player>() );
    }

    public List<List<Player>> getColumns()
    {
        return columns;
    }

    public void setColumns( List<List<Player>> columns )
    {
        this.columns = columns;
    }

    public Player getPieceAt( int x, int y )
        throws IllegalArgumentException
    {
        // TODO: Duplication
        if ( x >= MAX_COLUMNS || x < 0 )
        {
            throw new IllegalArgumentException( "Column [" + x + "] is invalid." );
        }

        if ( y >= MAX_ROWS || y < 0 )
        {
            throw new IllegalArgumentException( "Row [" + y + "] is invalid." );
        }

        if ( columns.get( x ).size() <= y )
        {
            return null;
        }

        return columns.get( x ).get( y );
    }

    public void putPiece( int x, Player player )
        throws IllegalArgumentException, ColumnFullException
    {
        // TODO: Duplication
        if ( x >= MAX_COLUMNS || x < 0 )
        {
            throw new IllegalArgumentException( "Column [" + x + "] is invalid." );
        }

        if ( columns.get( x ).size() >= MAX_ROWS )
        {
            throw new ColumnFullException();
        }

        columns.get( x ).add( player );
    }

    public int getNumberOfRows()
    {
        return MAX_ROWS;
    }

    public int getNumberOfColumns()
    {
        return MAX_COLUMNS;
    }

    public boolean isColumnFull( int x )
    {
        return columns.get( x ).size() >= MAX_ROWS;
    }

    public boolean isBoardFull()
    {
        for ( int x = 0; x < MAX_COLUMNS; ++x )
        {
            if ( !isColumnFull( x ) )
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString()
    {
        String string = "";

        for ( int y = MAX_ROWS - 1; y >= 0; --y )
        {
            for ( int x = 0; x < MAX_COLUMNS; ++x )
            {
                Player player = getPieceAt( x, y );
                if ( player == null )
                {
                    string += ". ";
                }
                else if ( player == Player.RED )
                {
                    string += "r ";
                }
                else
                {
                    string += "B ";
                }
            }
            string += "\n";
        }
        return string;
    }
}
