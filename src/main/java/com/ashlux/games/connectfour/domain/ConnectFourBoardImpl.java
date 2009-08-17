package com.ashlux.games.connectfour.domain;

import com.sun.javaws.exceptions.InvalidArgumentException;
import com.sun.istack.internal.NotNull;
import com.ashlux.games.connectfour.domain.exception.ColumnFullException;

import java.util.List;
import java.util.LinkedList;

public class ConnectFourBoardImpl
    implements ConnectFourBoard
{
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
        throws InvalidArgumentException
    {
        return null;
    }

    public void putPiece( int x, @NotNull Player player )
        throws InvalidArgumentException, ColumnFullException
    {
    }
}
