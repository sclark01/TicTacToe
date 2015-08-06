package com.thoughtworks.tictactoe;

import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
    private Board board;
    private Boolean keepPlaying;
    private PrintStream printStream;
    private List<Player> players;

    public TicTacToe(Board board, TicTacBufferedReader reader, PrintStream printStream) {
        this.board = board;
        this.printStream = printStream;
        players = new ArrayList<>();
        players.add(new Player(printStream, reader, "X"));
        players.add(new Player(printStream, reader, "O"));
        keepPlaying = true;
    }

    public void play() {
        Boolean continuePlayersTurn;
        board.drawBoard();
        while (keepPlaying) {
            for (Player player : players) {
                continuePlayersTurn = true;
                while (continuePlayersTurn) {
                    try {
                        board.move(player.readMove(), player.symbol);
                        continuePlayersTurn = false;
                    } catch (IllegalMove illegalMove) {
                        printStream.println("Location already taken. Try again.");
                    }
                }
                if(board.isDraw()) {
                    board.drawBoard();
                    return;
                }
                board.drawBoard();
            }
//            keepPlaying = !board.isDraw();
//            System.out.println(keepPlaying);
        }
    }
}
