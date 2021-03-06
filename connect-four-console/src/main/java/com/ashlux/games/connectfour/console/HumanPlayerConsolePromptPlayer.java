package com.ashlux.games.connectfour.console;

import com.ashlux.games.connectfour.business.players.ConnectFourPlayer;
import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.GamePiece;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Not thread-safe.
 */
public class HumanPlayerConsolePromptPlayer
    implements ConnectFourPlayer
{
    private OutputStream outputStream;

    private BufferedReader bufferedReader;

    public HumanPlayerConsolePromptPlayer( OutputStream outputStream, InputStream inputStream )
    {
        bufferedReader = new BufferedReader( new InputStreamReader( inputStream ) );
        this.outputStream = outputStream;
    }

    public int decide( ConnectFourBoard connectFourBoard, GamePiece computerGamePiece )
    {
        return getResponse( connectFourBoard );
    }

    private int getResponse( ConnectFourBoard connectFourBoard )
    {
        try
        {
            IOUtils.write( "\n" + connectFourBoard.toString() + "\n", outputStream );

            IOUtils.write( "\nSelect column [0-6]: ", outputStream );

            String input = bufferedReader.readLine();
            int selectedColumn = Integer.parseInt( input );
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

}
