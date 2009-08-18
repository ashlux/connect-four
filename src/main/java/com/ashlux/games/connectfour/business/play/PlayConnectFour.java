package com.ashlux.games.connectfour.business.play;

import com.ashlux.games.connectfour.business.players.ConnectFourPlayer;
import com.ashlux.games.connectfour.domain.ConnectFourBoard;
import com.ashlux.games.connectfour.domain.GamePiece;

public class PlayConnectFour
{
    private ConnectFourPlayer firstPlayer;

    private GamePiece firstGamePiecePiece;

    private ConnectFourPlayer secondPlayer;

    private GamePiece secondGamePiecePiece;

    private ConnectFourScorer connectFourScorer;

    private ConnectFourBoard connectFourBoard;

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

    public GamePiece getFirstGamePiecePiece()
    {
        return firstGamePiecePiece;
    }

    public void setFirstGamePiecePiece( GamePiece firstGamePiecePiece )
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

    public GamePiece getSecondGamePiecePiece()
    {
        return secondGamePiecePiece;
    }

    public void setSecondGamePiecePiece( GamePiece secondGamePiecePiece )
    {
        this.secondGamePiecePiece = secondGamePiecePiece;
    }

    public ConnectFourScorer getConnectFourScorer()
    {
        return connectFourScorer;
    }

    public void setConnectFourScorer( ConnectFourScorer connectFourScorer )
    {
        this.connectFourScorer = connectFourScorer;
    }

    public ConnectFourBoard getConnectFourBoard()
    {
        return connectFourBoard;
    }

    public void setConnectFourBoard( ConnectFourBoard connectFourBoard )
    {
        this.connectFourBoard = connectFourBoard;
    }
}
