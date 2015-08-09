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
    public void shouldAddPlayerToDesiredSpot() throws IllegalMove {
        assertEquals(true, board.isAvailable(1));
        board.mark(1, "X");
        assertEquals(false, board.isAvailable(1));
    }

    @Test
    public void shouldReturnFalseIfSpaceIsTaken() throws IllegalMove {
        board.mark(1, "X");
        assertEquals(false, board.isAvailable(1));
    }

    @Test (expected = IllegalMove.class)
    public void shouldThrowErrorWhenUserTriesToMoveToOccupiedSpace() throws IllegalMove {
        board.mark(1, "X");
        board.mark(1, "X");
    }

    @Test
    public void shouldReturnTrueWhenBoardIsFull() throws IllegalMove {
        for (int i = 0; i < 9; i++) {
            board.mark(i, "X");
        }
        assertEquals(true, board.isDraw());
    }

    @Test
    public void shouldDetectAWinWhenThreeOfTheSameSymbolsAreInARow() throws IllegalMove {
        for (int i = 0; i < 3; i++){
            board.mark(i, "X");
        }
        assertEquals(true, board.isWin());
    }

    @Test
    public void shouldNotDetectAWinWhenThreeDifferentSymbolsAreInARow() throws IllegalMove {
        board.mark(0, "X");
        board.mark(1, "Y");
        board.mark(2, "Y");
        assertEquals(false, board.isWin());
    }


    @Test
    public void shouldDetectAWinWhenThreeOfTheSameSymbolsAreInAColumn() throws IllegalMove {
        board.mark(0, "X");
        board.mark(3, "X");
        board.mark(6, "X");
        assertEquals(true, board.isWin());
    }

    @Test
    public void shouldDetectAWinWhenThreeOfTheSameSymbolsAreInADiagonal() throws IllegalMove {
        board.mark(0, "X");
        board.mark(4, "X");
        board.mark(8, "X");
        assertEquals(true, board.isWin());
    }
}