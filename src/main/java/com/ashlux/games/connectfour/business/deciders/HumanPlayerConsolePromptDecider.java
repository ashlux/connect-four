package com.ashlux.games.connectfour.business.deciders;

import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.Player;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HumanPlayerConsolePromptDecider
    implements ConnectFourDecider
{
    private OutputStream outputStream;

    private InputStream inputStream;

    public HumanPlayerConsolePromptDecider( OutputStream outputStream, InputStream inputStream )
    {
        this.outputStream = outputStream;
        this.inputStream = inputStream;
    }

    public int decide( ConnectFourBoard connectFourBoard, Player computerPlayer )
    {
        return getResponse( connectFourBoard );
    }

    private int getResponse( ConnectFourBoard connectFourBoard )
    {
        try
        {
            IOUtils.write( "\n" + connectFourBoard.toString() + "\n", outputStream );

            IOUtils.write( "\nSelect column [0-6]: ", outputStream );

            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( inputStream ) );
            String input = bufferedReader.readLine();
            IOUtils.write( input + "\n\n", outputStream );

            int selectedColumn = Integer.parseInt( String.valueOf( input.charAt( 0 ) ) );
            if ( selectedColumn < 0 || selectedColumn > connectFourBoard.getNumberOfColumns() )
            {
                IOUtils.write( "Invalid column, please try again.\n", outputStream );
                return getResponse( connectFourBoard );
            }

            if ( connectFourBoard.isColumnFull( selectedColumn ) )
            {
                IOUtils.write( "Column is full, please try again.\n", outputStream );
                return getResponse( connectFourBoard );
            }

            return selectedColumn;
        }
        catch ( Exception e )
        {
            return getResponse( connectFourBoard );
        }
    }

    public String deciderName()
    {
        return "HUMAN";
    }
}
