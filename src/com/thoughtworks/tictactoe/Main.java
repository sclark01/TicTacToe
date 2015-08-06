package com.thoughtworks.tictactoe;

import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(new Board(System.out), new TicTacBufferedReader(new InputStreamReader(System.in)), System.out);
        game.play();
    }
}
