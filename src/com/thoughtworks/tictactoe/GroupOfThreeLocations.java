package com.thoughtworks.tictactoe;

public class GroupOfThreeLocations {

    private String symbol;
    private Integer count;
    private Boolean areSymbolsDifferent;

    public GroupOfThreeLocations() {
        symbol = null;
        count = 0;
        areSymbolsDifferent = false;
    }


    public boolean isEmpty() {
        return symbol == null;
    }

    public void addToGroup(String symbolToAdd) {
        if(symbol != null && !symbol.equals(symbolToAdd)){
            areSymbolsDifferent = true;
        }
        symbol = symbolToAdd;
        count++;
    }

    public boolean isFull() {
        return count == 3;
    }

    public boolean areSymbolsDifferent() {
        return areSymbolsDifferent;
    }
}
