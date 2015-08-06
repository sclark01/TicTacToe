package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerTest {
    private PrintStream printStream;
    private Player player;
    private TicTacBufferedReader reader;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        reader = mock(TicTacBufferedReader.class);
        player = new Player(printStream, reader, "X");
    }

    @Test
    public void shouldPromptPlayerToMakeAMove(){
        when(reader.readLine()).thenReturn("1");
        player.readMove();
        verify(printStream).println(contains("make your move"));
    }

    @Test
    public void shouldReadPlayerInput() {
        when(reader.readLine()).thenReturn("1");
        player.readMove();
        verify(reader).readLine();
    }

}