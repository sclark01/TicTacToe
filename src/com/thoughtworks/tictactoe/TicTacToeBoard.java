package com.thoughtworks.tictactoe;


import java.io.PrintStream;
import java.util.ArrayList;

public class TicTacToeBoard extends Board{
    private GroupOfThreeLocations topRow;
    private GroupOfThreeLocations middleRow;
    private GroupOfThreeLocations bottomRow;

    private GroupOfThreeLocations leftColumn;
    private GroupOfThreeLocations middleColumn;
    private GroupOfThreeLocations rightColumn;

    private GroupOfThreeLocations backSlashDiagonal;
    private GroupOfThreeLocations forwardSlashDiagonal;

    private ArrayList<GroupOfThreeLocations> groups;

    public TicTacToeBoard(PrintStream printStream, GroupOfThreeLocations topRow, GroupOfThreeLocations middleRow, GroupOfThreeLocations bottomRow, GroupOfThreeLocations leftColumn, GroupOfThreeLocations middleColumn, GroupOfThreeLocations rightColumn, GroupOfThreeLocations backSlashDiagonal, GroupOfThreeLocations forwardSlashDiagonal) {
        super(printStream);

        groups = new ArrayList<>();

        this.topRow = topRow;
        this.middleRow = middleRow;
        this.bottomRow = bottomRow;

        this.leftColumn =leftColumn;
        this.middleColumn = middleColumn;
        this.rightColumn = rightColumn;

        this.backSlashDiagonal = backSlashDiagonal;
        this.forwardSlashDiagonal = forwardSlashDiagonal;

        addGroupsToList();
    }


    @Override
    public void mark(int i, String symbol) throws IllegalMove {
        super.mark(i, symbol);
        addMarkToProperGroup(i, symbol);
    }

    @Override
    public boolean isWin() {
        for (GroupOfThreeLocations group : groups) {
            if(group.isFull()){
                if(!group.areSymbolsDifferent()){
                    return true;
                }
            }
        }
       return false;
    }

    private void addMarkToProperGroup(int location, String symbol) {
        switch (location){
            case 0:
                topRow.addToGroup(symbol);
                leftColumn.addToGroup(symbol);
                backSlashDiagonal.addToGroup(symbol);
                break;
            case 1:
                topRow.addToGroup(symbol);
                middleColumn.addToGroup(symbol);
                break;
            case 2:
                topRow.addToGroup(symbol);
                rightColumn.addToGroup(symbol);
                forwardSlashDiagonal.addToGroup(symbol);
                break;
            case 3:
                middleRow.addToGroup(symbol);
                leftColumn.addToGroup(symbol);
                break;
            case 4:
                middleRow.addToGroup(symbol);
                middleColumn.addToGroup(symbol);
                forwardSlashDiagonal.addToGroup(symbol);
                backSlashDiagonal.addToGroup(symbol);
                break;
            case 5:
                middleRow.addToGroup(symbol);
                rightColumn.addToGroup(symbol);
                break;
            case 6:
                bottomRow.addToGroup(symbol);
                leftColumn.addToGroup(symbol);
                forwardSlashDiagonal.addToGroup(symbol);
                break;
            case 7:
                bottomRow.addToGroup(symbol);
                middleColumn.addToGroup(symbol);
                break;
            case 8:
                bottomRow.addToGroup(symbol);
                rightColumn.addToGroup(symbol);
                backSlashDiagonal.addToGroup(symbol);
                break;
            default:
                break;
        }
    }


    private void addGroupsToList() {
        groups.add(topRow);
        groups.add(middleRow);
        groups.add(bottomRow);

        groups.add(leftColumn);
        groups.add(middleColumn);
        groups.add(rightColumn);

        groups.add(backSlashDiagonal);
        groups.add(forwardSlashDiagonal);
    }
}
