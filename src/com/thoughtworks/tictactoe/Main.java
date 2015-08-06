package com.thoughtworks.tictactoe;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(new Board(System.out));
        game.play();
    }
}
