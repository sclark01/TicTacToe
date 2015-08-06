package com.thoughtworks.tictactoe;

public class TicTacToe {
    private Board board;

    public TicTacToe(Board board) {
        this.board = board;
    }

    public void play() {
        board.drawBoard();
    }
}
