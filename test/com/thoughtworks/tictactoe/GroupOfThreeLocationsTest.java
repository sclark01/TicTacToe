package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class GroupOfThreeLocationsTest {


    private final String ANY_SYMBOL = "X";
    private GroupOfThreeLocations group;

    @Before
    public void setUp() throws Exception {
        group = new GroupOfThreeLocations();
    }

    @Test
    public void shouldReturnTrueWhenTheGroupIsEmpty(){
        assertTrue(group.isEmpty());
    }

    @Test
    public void shouldReturnFalseWhenGroupIsNotEmpty(){
        group.addToGroup(ANY_SYMBOL);
        assertFalse(group.isEmpty());
    }

    @Test
    public void shouldReturnTrueWhenTheGroupIsFull(){
        for (int i = 0; i < 3; i++) {
            group.addToGroup(ANY_SYMBOL);
        }
        assertTrue(group.isFull());
    }

    @Test
    public void shouldReturnFalseWhenTheGroupIsNotFull(){
        group.addToGroup(ANY_SYMBOL);
        assertFalse(group.isFull());
    }

    @Test
    public void shouldReturnFalseWhenNoSymbolsInGroupAreDifferent(){
        group.addToGroup(ANY_SYMBOL);
        group.addToGroup(ANY_SYMBOL);
        assertFalse(group.areSymbolsDifferent());
    }

    @Test
    public void shouldReturnTrueWhenThereAreDifferentSymbolsInTheGroup(){
        String different_symbol = "Y";
        group.addToGroup(ANY_SYMBOL);
        group.addToGroup(different_symbol);
        assertTrue(group.areSymbolsDifferent());
    }

}