package com.ashlux.games.connectfour.business.players;

import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.ConnectFourBoardFactory;
import com.ashlux.games.connectfour.domain.GamePiece;
import com.ashlux.games.connectfour.domain.exception.ColumnFullException;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HumanPlayerConsolePromptDeciderTest
{
    @Test
    public void test_selectColumnZero()
        throws IOException
    {
        ConnectFourBoard connectFourBoard = ConnectFourBoardFactory.createEmptyBoard();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream( "0\n".getBytes() );
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HumanPlayerConsolePromptPlayer humanPlayerConsolePromptDecider =
            new HumanPlayerConsolePromptPlayer( byteArrayOutputStream, byteArrayInputStream );

        int selectedColumn = humanPlayerConsolePromptDecider.decide( connectFourBoard, GamePiece.RED );

        assertEquals( selectedColumn, 0 );
        assertEquals( new String( byteArrayOutputStream.toByteArray() ),
                      "\n" + ". . . . . . . \n" + ". . . . . . . \n" + ". . . . . . . \n" + ". . . . . . . \n" +
                          ". . . . . . . \n" + ". . . . . . . \n\n\n" + "Select column [0-6]: " );
    }

    @Test
    public void test_selectInvalidNegativeColumn()
        throws IOException
    {
        ConnectFourBoard connectFourBoard = ConnectFourBoardFactory.createEmptyBoard();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream( "-100\n1\n".getBytes() );
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HumanPlayerConsolePromptPlayer humanPlayerConsolePromptDecider =
            new HumanPlayerConsolePromptPlayer( byteArrayOutputStream, byteArrayInputStream );

        int selectedColumn = humanPlayerConsolePromptDecider.decide( connectFourBoard, GamePiece.RED );

        assertEquals( selectedColumn, 1 );
        String output = new String( byteArrayOutputStream.toByteArray() );
        assertTrue( output.contains( "Invalid column, please try again." ) );
    }

    @Test
    public void test_selectColumnTooLarge()
        throws IOException
    {
        ConnectFourBoard connectFourBoard = ConnectFourBoardFactory.createEmptyBoard();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream( "10000\n2\n".getBytes() );
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HumanPlayerConsolePromptPlayer humanPlayerConsolePromptDecider =
            new HumanPlayerConsolePromptPlayer( byteArrayOutputStream, byteArrayInputStream );

        int selectedColumn = humanPlayerConsolePromptDecider.decide( connectFourBoard, GamePiece.RED );

        assertEquals( selectedColumn, 2 );
        String output = new String( byteArrayOutputStream.toByteArray() );
        assertTrue( output.contains( "Invalid column, please try again." ) );
    }

    @Test
    public void test_selectColumnTooFull()
        throws IOException, ColumnFullException
    {
        ConnectFourBoard connectFourBoard = ConnectFourBoardFactory.createEmptyBoard();
        connectFourBoard.putPiece( 0, GamePiece.RED );
        connectFourBoard.putPiece( 0, GamePiece.RED );
        connectFourBoard.putPiece( 0, GamePiece.RED );
        connectFourBoard.putPiece( 0, GamePiece.RED );
        connectFourBoard.putPiece( 0, GamePiece.RED );
        connectFourBoard.putPiece( 0, GamePiece.RED );

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream( "0\n3\n".getBytes() );
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HumanPlayerConsolePromptPlayer humanPlayerConsolePromptDecider =
            new HumanPlayerConsolePromptPlayer( byteArrayOutputStream, byteArrayInputStream );

        int selectedColumn = humanPlayerConsolePromptDecider.decide( connectFourBoard, GamePiece.RED );

        assertEquals( selectedColumn, 3 );
        String output = new String( byteArrayOutputStream.toByteArray() );
        assertTrue( output.contains( "Column is full, please try again." ) );
    }}
