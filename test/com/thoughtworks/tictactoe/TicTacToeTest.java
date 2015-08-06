package com.thoughtworks.tictactoe;


import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TicTacToeTest {

    @Test
    public void shouldCallDrawBoard(){
        Board board = mock(Board.class);
        PrintStream printStream = mock(PrintStream.class);
        TicTacBufferedReader reader = mock(TicTacBufferedReader.class);
        TicTacToe game = new TicTacToe(board);
        game.play();
        verify(board).drawBoard();
    }
}