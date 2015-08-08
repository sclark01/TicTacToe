package com.thoughtworks.tictactoe;

import java.io.PrintStream;

public class ComputerPlayer extends Player {

    public ComputerPlayer(PrintStream printStream, TicTacBufferedReader reader, String symbol) {
        super(printStream, reader, symbol);
    }

    @Override
    public int readMove() {
        return 0;
    }
}
