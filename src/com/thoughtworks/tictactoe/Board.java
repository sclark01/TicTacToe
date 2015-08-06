package com.thoughtworks.tictactoe;

import java.io.PrintStream;

public class Board {
    public static final int BOARD_SIZE = 9;
    private PrintStream printStream;
    private String[] board;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
        board = new String[BOARD_SIZE];
        init();
    }

    public void drawBoard() {
        printStream.println(toString());
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < BOARD_SIZE; i++){
            if (i % 3 == 0 && i > 1){
                output += "\n------------\n";
            }
            if (i % 3 != 0) {
                output += "|";
            }
            output += " " + board[i] + " ";
        }
        return output;
    }

    private void init() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i] = " ";
        }
    }

    public void move(int i, String symbol) throws IllegalMove {
        if(!isAvailable(i)) throw new IllegalMove("Space Taken");
        board[i] = symbol;
    }

    public boolean isAvailable(int i) {
        return board[i].equals(" ");
    }
}
