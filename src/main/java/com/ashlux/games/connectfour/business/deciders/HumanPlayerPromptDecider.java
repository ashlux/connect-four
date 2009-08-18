package com.ashlux.games.connectfour.business.deciders;

import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.Player;

public class HumanPlayerPromptDecider
    implements ConnectFourDecider
{
    public int decide( ConnectFourBoard connectFourBoard, Player computerPlayer )
    {
        System.out.println();
        System.out.println( connectFourBoard );
        System.out.println();

        return getResponse( connectFourBoard );
    }

    private int getResponse(ConnectFourBoard connectFourBoard)
    {
        try
        {
            System.out.print( "Select column [0-6]: " );
            char choice = (char) System.in.read();

            int selectedColumn = Integer.parseInt( String.valueOf( choice ) );
            if ( selectedColumn < 0 || selectedColumn > connectFourBoard.getNumberOfColumns() )
            {
                System.out.println("Invalid column, please try again.");
                return getResponse( connectFourBoard );
            }

            if (connectFourBoard.isColumnFull( selectedColumn ))
            {
                System.out.println("Column is full, please try again.");
                return getResponse( connectFourBoard );
            }

            return selectedColumn;
        }
        catch ( Exception e )
        {
            System.out.println( "Error reading response, please try again." );
            return getResponse(connectFourBoard);
        }
    }

    public String deciderName()
    {
        return "HUMAN";
    }
}
