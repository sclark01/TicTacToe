package com.thoughtworks.tictactoe;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TicTacToeTest {

    private Board board;
    private PrintStream printStream;
    private TicTacBufferedReader reader;
    private TicTacToe game;

    @Before
    public void setUp(){
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        reader = mock(TicTacBufferedReader.class);
        game = new TicTacToe(board, reader, printStream);
    }

    @Ignore
    public void shouldCallDrawBoard(){
        when(reader.readLine()).thenReturn("1", "2");
        game.play();
        verify(board, atLeastOnce()).drawBoard();
    }

    @Test
    public void gameShouldContinueUntilBoardIsFull(){
        Board board = new Board(printStream);
        TicTacToe game = new TicTacToe(board, reader, printStream);
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

}