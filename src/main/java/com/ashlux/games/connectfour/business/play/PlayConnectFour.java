package com.ashlux.games.connectfour.business.play;

import com.ashlux.games.connectfour.business.play.ConnectFourScorer;
import com.ashlux.games.connectfour.business.play.ConnectFourScorerImpl;
import com.ashlux.games.connectfour.business.deciders.ConnectFourDecider;
import com.ashlux.games.connectfour.business.deciders.HumanPlayerConsolePromptDecider;
import com.ashlux.games.connectfour.business.deciders.RandomConnectFourDecider;
import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.ConnectFourBoardFactory;
import com.ashlux.games.connectfour.domain.Player;
import org.testng.annotations.Test;

public class PlayConnectFour
{
    @Test
    public void play()
        throws Exception
    {
        ConnectFourDecider playerOne = new HumanPlayerConsolePromptDecider( System.out, System.in );
        Player playerOnePiece = Player.RED;
        ConnectFourDecider playerTwo = new RandomConnectFourDecider();
        Player playerTwoPiece = Player.BLACK;

        ConnectFourScorer connectFourScorer = new ConnectFourScorerImpl();
        ConnectFourBoard connectFourBoard = ConnectFourBoardFactory.createEmptyBoard();

        boolean playerOneTurn = true;
        do
        {
            if ( playerOneTurn )
            {
                int columnChoice = playerOne.decide( connectFourBoard, playerOnePiece );
                connectFourBoard.putPiece( columnChoice, playerOnePiece );
                System.out.println( "Player ONE choose column [" + columnChoice + "-" + playerOnePiece + "]" );
            }
            else
            {
                int columnChoice = playerTwo.decide( connectFourBoard, playerTwoPiece );
                connectFourBoard.putPiece( columnChoice, playerTwoPiece );
                System.out.println( "Player TWO choose column [" + columnChoice + "-" + playerTwoPiece + "]" );
            }

            playerOneTurn = !playerOneTurn;
        }
        while ( !connectFourScorer.isGameOver( connectFourBoard ) );

        Player winner = connectFourScorer.getWinner( connectFourBoard );
        System.out.println( "\n" + connectFourBoard.toString() );
        System.out.println( "Winner is " + ( winner == null ? "a tie" : winner ) + "!" );
    }

    @Test
    public void test()
        throws Exception
    {
        ConnectFourBoard connectFourBoard = ConnectFourBoardFactory.createEmptyBoard();
        connectFourBoard.putPiece( 0, Player.BLACK );

        System.out.println( connectFourBoard );
    }
}
