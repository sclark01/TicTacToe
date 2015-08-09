package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class TicTacToeBoardTest {

    private GroupOfThreeLocations group;
    private GroupOfThreeLocations differentGroup;
    private TicTacToeBoard board;

    @Before
    public void setUp() throws Exception {
        group = mock(GroupOfThreeLocations.class);
        differentGroup = mock(GroupOfThreeLocations.class);
        board = new TicTacToeBoard(System.out, group, differentGroup, differentGroup, group, differentGroup, differentGroup, group, differentGroup);
    }

    @Test
    public void shouldAddSymbolToGroup() throws IllegalMove {
        board.mark(0, "X");
        verify(group, atLeastOnce()).addToGroup("X");
        verify(differentGroup, never()).addToGroup("X");
    }

    @Test
    public void shouldReportWinWhenThereIsAGroupThatIsFullAndWithAllTheSameSymbol(){
        when(group.isFull()).thenReturn(true);
        when(group.areSymbolsDifferent()).thenReturn(false);
        assertTrue(board.isWin());
    }

    @Test
        public void shouldNotReportWinWhenThereIsAGroupThatIsNotFull(){
        when(group.isFull()).thenReturn(false);
        when(group.areSymbolsDifferent()).thenReturn(false);
        assertFalse(board.isWin());
    }

    @Test
    public void shouldNotReportWinWhenThereIsAGroupWithDifferentSymbols(){
        when(group.isFull()).thenReturn(true);
        when(group.areSymbolsDifferent()).thenReturn(true);
        assertFalse(board.isWin());
    }
}