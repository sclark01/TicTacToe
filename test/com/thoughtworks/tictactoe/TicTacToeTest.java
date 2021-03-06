package com.thoughtworks.tictactoe;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TicTacToeTest {

    private TicTacToeBoard board;
    private PrintStream printStream;
    private TicTacBufferedReader reader;
    private TicTacToe game;

    @Before
    public void setUp(){
        board = mock(TicTacToeBoard.class);
        printStream = mock(PrintStream.class);
        reader = mock(TicTacBufferedReader.class);
        game = new TicTacToe(board, printStream, new Player(printStream, reader, "X"), new Player(printStream, reader, "O"));
    }

    @Test
    public void shouldCallDrawBoard(){
        when(reader.readLine()).thenReturn("1", "2");
        when(board.isWin()).thenReturn(true);
        game.play();
        verify(board, atLeastOnce()).drawBoard();
    }

    @Test
    public void gameShouldContinueUntilBoardIsFull(){
        GroupOfThreeLocations mockGroup = mock(GroupOfThreeLocations.class);
        TicTacToeBoard board = new TicTacToeBoard(printStream, mockGroup, mockGroup, mockGroup, mockGroup, mockGroup, mockGroup, mockGroup, mockGroup);
        TicTacToe game = new TicTacToe(board, printStream, new Player(printStream, reader, "X"), new Player(printStream, reader, "O"));
        when(reader.readLine()).thenReturn("1", "2", "4", "8", "5", "6", "3", "7", "9");
        game.play();
        assertEquals(true, board.isDraw());
    }

    @Test
    public void shouldPrintBoardWhenBoardIsFullWithNoWinner(){
        when(reader.readLine()).thenReturn("1", "2");
        when(board.isDraw()).thenReturn(true);
        game.play();
        verify(board, times(2)).drawBoard();
    }

    @Test
    public void shouldPrintWinningPlayerNumber(){
        when(reader.readLine()).thenReturn("1");
        when(board.isWin()).thenReturn(true);
        game.play();
        verify(printStream).print(contains(" wins"));
    }

}