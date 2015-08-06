package com.thoughtworks.tictactoe;


import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {
    @Test
    public void shouldDrawBoard(){
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);
        board.drawBoard();
        verify(printStream).print("  |   |   \n" +
                "---------\n" +
                "  |   |   \n" +
                "---------\n" +
                "  |   |   \n");
    }
}