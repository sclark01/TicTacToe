package com.thoughtworks.tictactoe;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.contains;
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
    public void shouldAddPlayerToDesiredSpot() throws IllegalMove {
        assertEquals(true, board.isAvailable(1));
        board.move(1, "X");
        assertEquals(false, board.isAvailable(1));
    }

    @Test
    public void shouldReturnFalseIfSpaceIsTaken() throws IllegalMove {
        board.move(1, "X");
        assertEquals(false, board.isAvailable(1));
    }

    @Test (expected = IllegalMove.class)
    public void shouldThrowErrorWhenUserTriesToMoveToOccupiedSpace() throws IllegalMove {
        board.move(1, "X");
        board.move(1, "X");
    }

    @Test
    public void shouldReturnTrueWhenBoardIsFull() throws IllegalMove {
        for (int i = 0; i < 9; i++) {
            board.move(i, "X");
        }
        assertEquals(true, board.isDraw());
    }

}