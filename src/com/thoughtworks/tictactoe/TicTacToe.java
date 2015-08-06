package com.thoughtworks.tictactoe;

import java.io.InputStreamReader;

public class TicTacToe {
    private Board board;
    private Player player1;
    private Player player2;

    public TicTacToe(Board board) {
        this.board = board;
        player1 = new Player(System.out, new TicTacBufferedReader(new InputStreamReader(System.in)), "X");
        player2 = new Player(System.out, new TicTacBufferedReader(new InputStreamReader(System.in)), "O");
    }

    public void play() {
        board.drawBoard();
        board.move(player1.readMove(), player1.symbol);
        board.drawBoard();
        board.move(player2.readMove(), player2.symbol);
        board.drawBoard();
    }
}
