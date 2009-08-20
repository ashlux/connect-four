package com.ashlux.games.connectfour.console;

import com.ashlux.games.connectfour.business.play.ConnectFourGameController;
import com.ashlux.games.connectfour.business.play.ConnectFourScorerImpl;
import com.ashlux.games.connectfour.business.players.RandomConnectFourPlayer;
import com.ashlux.games.connectfour.domain.ConnectFourBoardFactory;
import com.ashlux.games.connectfour.domain.GamePiece;

public class ConnectFourConsoleGame
{
    public static void main( String[] args )
        throws Exception
    {
        ConnectFourGameController connectFourGameController = new ConnectFourGameController();
        connectFourGameController.setConnectFourBoard( ConnectFourBoardFactory.createEmptyBoard() );
        connectFourGameController.setConnectFourScorer( new ConnectFourScorerImpl() );
        connectFourGameController.setFirstPlayer( new HumanPlayerConsolePromptPlayer( System.out, System.in ) );
        connectFourGameController.setFirstGamePiecePiece( GamePiece.RED );
        connectFourGameController.setSecondPlayer( new RandomConnectFourPlayer() );
        connectFourGameController.setSecondGamePiecePiece( GamePiece.BLACK );
        connectFourGameController.play();

        GamePiece winner = connectFourGameController.getConnectFourScorer().getWinner(
            connectFourGameController.getConnectFourBoard() );
        if (winner == null)
        {
            System.out.println("Winner is a TIE!");
        }
        else
        {
            System.out.println("Winner is " + winner + "!");
        }
    }
}
