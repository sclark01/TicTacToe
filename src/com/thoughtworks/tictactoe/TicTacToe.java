package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
    private Board board;
    private Boolean keepPlaying;
    private PrintStream printStream;
    private List<Player> players;

    public TicTacToe(Board board, PrintStream printStream, Player playerOne, Player playerTwo) {
        this.board = board;
        this.printStream = printStream;
        players = new ArrayList<>();
        players.add(playerOne);
        players.add(playerTwo);
        //players.add(new ComputerPlayer(printStream, reader, "O"));
        keepPlaying = true;
    }

    public void play() {
        board.drawBoard();
        while (keepPlaying) {
            for (Player player : players) {
                playersTurn(player);
                board.drawBoard();
                if(isEndOfGame(player.playerNumber)) return;
            }
        }
    }

    private void playersTurn(Player player) {
        Boolean continuePlayersTurn;
        continuePlayersTurn = true;
        while (continuePlayersTurn) {
            try {
                board.mark(player.readMove(), player.symbol);
                continuePlayersTurn = false;
            } catch (IllegalMove illegalMove) {
                printStream.println("Location already taken. Try again.");
            }
        }
    }

    private boolean isEndOfGame(int playerNumber) {
        if (board.isWin()){
            printStream.print("Player " + playerNumber + " wins\n");
            return true;
        }
        if (board.isDraw()) {
            printStream.println("Game is a draw");
            return true;
        }
        return false;
    }
}
