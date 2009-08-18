package com.ashlux.games.connectfour.business.play;

import com.ashlux.games.connectfour.business.players.ConnectFourPlayer;
import com.ashlux.games.connectfour.business.players.HumanPlayerConsolePromptPlayer;
import com.ashlux.games.connectfour.business.players.RandomConnectFourPlayer;
import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.ConnectFourBoardFactory;
import com.ashlux.games.connectfour.domain.Player;

public class PlayConnectFour
{
    public void play()
        throws Exception
    {
        ConnectFourPlayer playerOne = new HumanPlayerConsolePromptPlayer( System.out, System.in );
        Player playerOnePiece = Player.RED;
        ConnectFourPlayer playerTwo = new RandomConnectFourPlayer();
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
}
