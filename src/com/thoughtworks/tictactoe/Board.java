package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int BOARD_SIZE = 9;
    private PrintStream printStream;
    private List<String> board;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
        board = new ArrayList<>();
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
            output += " " + board.get(i) + " ";
        }
        return output;
    }

    private void init() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board.add(" ");
        }
    }

}
