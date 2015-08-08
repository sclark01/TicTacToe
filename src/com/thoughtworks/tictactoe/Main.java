package com.thoughtworks.tictactoe;

import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        final TicTacBufferedReader reader = new TicTacBufferedReader(new InputStreamReader(System.in));
        TicTacToe game = new TicTacToe(new Board(System.out), System.out, new Player(System.out, reader, "X"), new Player(System.out, reader, "O"));
        game.play();
    }
}
