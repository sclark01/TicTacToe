package com.thoughtworks.tictactoe;

import java.io.PrintStream;

public class Player {

    private TicTacBufferedReader reader;
    private PrintStream printStream;
    private static int playerCount;
    public final int playerNumber;
    public final String symbol;

    public Player(PrintStream printStream, TicTacBufferedReader reader, String symbol) {
        this.printStream = printStream;
        this.reader = reader;
        this.symbol = symbol;
        playerNumber = playerCount + 1;
        playerCount++;
    }

    public int readMove() {
        promptPlayer();
        return readPlayerInput();
    }

    private int readPlayerInput() {
        return Integer.parseInt(reader.readLine()) - 1;
    }

    private void promptPlayer() {
        printStream.println("Player " + playerNumber + " make your move");
    }
}
