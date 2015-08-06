package com.thoughtworks.tictactoe;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private PrintStream printStream;
    private Board board;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldDrawBoard(){
        board.drawBoard();
        verify(printStream).println("   |   |   \n" +
                "------------\n" +
                "   |   |   \n" +
                "------------\n" +
                "   |   |   ");
    }

    @Test
    public void shouldAddPlayerToDesiredSpot(){
        assertEquals(true, board.isAvailable(1));
        board.move(1, "X");
        assertEquals(false, board.isAvailable(1));
    }

}