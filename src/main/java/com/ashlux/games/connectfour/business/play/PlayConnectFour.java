package com.ashlux.games.connectfour.business.play;

import com.ashlux.games.connectfour.business.players.ConnectFourPlayer;
import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.ConnectFourBoardFactory;
import com.ashlux.games.connectfour.domain.GamePiece;

public class PlayConnectFour
{
    private ConnectFourPlayer firstPlayer;

    private GamePiece firstGamePiecePiece;

    private ConnectFourPlayer secondPlayer;

    private GamePiece secondGamePiecePiece;

    private ConnectFourScorer connectFourScorer = new ConnectFourScorerImpl();

    private ConnectFourBoard connectFourBoard = ConnectFourBoardFactory.createEmptyBoard();

    public void play()
        throws Exception
    {
        boolean playerOneTurn = true;
        do
        {
            if ( playerOneTurn )
            {
                int columnChoice = firstPlayer.decide( connectFourBoard, firstGamePiecePiece );
                connectFourBoard.putPiece( columnChoice, firstGamePiecePiece );
                System.out.println( "Player ONE choose column [" + columnChoice + "-" + firstGamePiecePiece + "]" );
            }
            else
            {
                int columnChoice = secondPlayer.decide( connectFourBoard, secondGamePiecePiece );
                connectFourBoard.putPiece( columnChoice, secondGamePiecePiece );
                System.out.println( "Player TWO choose column [" + columnChoice + "-" + secondGamePiecePiece + "]" );
            }

            playerOneTurn = !playerOneTurn;
        }
        while ( !connectFourScorer.isGameOver( connectFourBoard ) );

        GamePiece winner = connectFourScorer.getWinner( connectFourBoard );
        System.out.println( "\n" + connectFourBoard.toString() );
        System.out.println( "Winner is " + ( winner == null ? "a tie" : winner ) + "!" );
    }

    public ConnectFourPlayer getFirstPlayer()
    {
        return firstPlayer;
    }

    public void setFirstPlayer( ConnectFourPlayer firstPlayer )
    {
        this.firstPlayer = firstPlayer;
    }

    public GamePiece getFirstPlayerPiece()
    {
        return firstGamePiecePiece;
    }

    public void setFirstPlayerPiece( GamePiece firstGamePiecePiece )
    {
        this.firstGamePiecePiece = firstGamePiecePiece;
    }

    public ConnectFourPlayer getSecondPlayer()
    {
        return secondPlayer;
    }

    public void setSecondPlayer( ConnectFourPlayer secondPlayer )
    {
        this.secondPlayer = secondPlayer;
    }

    public GamePiece getSecondPlayerPiece()
    {
        return secondGamePiecePiece;
    }

    public void setSecondPlayerPiece( GamePiece secondGamePiecePiece )
    {
        this.secondGamePiecePiece = secondGamePiecePiece;
    }
}
