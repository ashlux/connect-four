package com.ashlux.games.connectfour.business.deciders;

import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.ConnectFourBoardFactory;
import com.ashlux.games.connectfour.domain.Player;
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
        HumanPlayerConsolePromptDecider humanPlayerConsolePromptDecider =
            new HumanPlayerConsolePromptDecider( byteArrayOutputStream, byteArrayInputStream );

        int selectedColumn = humanPlayerConsolePromptDecider.decide( connectFourBoard, Player.RED );

        assertEquals( selectedColumn, 0 );
        assertEquals( new String( byteArrayOutputStream.toByteArray() ),
                      "\n" + ". . . . . . . \n" + ". . . . . . . \n" + ". . . . . . . \n" + ". . . . . . . \n" +
                          ". . . . . . . \n" + ". . . . . . . \n\n\n" + "Select column [0-6]: 0\n\n" );
    }

    @Test
    public void test_selectInvalidNegativeColumn()
        throws IOException
    {
        ConnectFourBoard connectFourBoard = ConnectFourBoardFactory.createEmptyBoard();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream( "-100\n1\n".getBytes() );
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HumanPlayerConsolePromptDecider humanPlayerConsolePromptDecider =
            new HumanPlayerConsolePromptDecider( byteArrayOutputStream, byteArrayInputStream );

        int selectedColumn = humanPlayerConsolePromptDecider.decide( connectFourBoard, Player.RED );

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
        HumanPlayerConsolePromptDecider humanPlayerConsolePromptDecider =
            new HumanPlayerConsolePromptDecider( byteArrayOutputStream, byteArrayInputStream );

        int selectedColumn = humanPlayerConsolePromptDecider.decide( connectFourBoard, Player.RED );

        assertEquals( selectedColumn, 2 );
        String output = new String( byteArrayOutputStream.toByteArray() );
        assertTrue( output.contains( "Invalid column, please try again." ) );
    }

    @Test
    public void test_selectColumnTooFull()
        throws IOException, ColumnFullException
    {
        ConnectFourBoard connectFourBoard = ConnectFourBoardFactory.createEmptyBoard();
        connectFourBoard.putPiece( 0, Player.RED );
        connectFourBoard.putPiece( 0, Player.RED );
        connectFourBoard.putPiece( 0, Player.RED );
        connectFourBoard.putPiece( 0, Player.RED );
        connectFourBoard.putPiece( 0, Player.RED );
        connectFourBoard.putPiece( 0, Player.RED );

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream( "0\n3\n".getBytes() );
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        HumanPlayerConsolePromptDecider humanPlayerConsolePromptDecider =
            new HumanPlayerConsolePromptDecider( byteArrayOutputStream, byteArrayInputStream );

        int selectedColumn = humanPlayerConsolePromptDecider.decide( connectFourBoard, Player.RED );

        assertEquals( selectedColumn, 3 );
        String output = new String( byteArrayOutputStream.toByteArray() );
        assertTrue( output.contains( "Column is full, please try again." ) );
    }}
