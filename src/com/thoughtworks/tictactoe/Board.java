package com.thoughtworks.tictactoe;

import java.io.PrintStream;

public class Board {
    public static final int BOARD_SIZE = 9;
    private PrintStream printStream;
    private String[] board;
    private int spaces_available;
    private int[] possibleNeighbors;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
        board = new String[BOARD_SIZE];
        spaces_available = BOARD_SIZE;
        possibleNeighbors = new int[BOARD_SIZE];
        init();
    }

    public void drawBoard() {
        printStream.println(toString());
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < BOARD_SIZE; i++){
            if (i % 3 == 0 && i > 1){
                output += "\n------------\n";
            }
            if (i % 3 != 0) {
                output += "|";
            }
            output += " " + board[i] + " ";
        }
        return output;
    }

    private void init() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i] = " ";
        }
        int neighbor = (BOARD_SIZE / 2) * -1;
        for (int j = 0; j < BOARD_SIZE; j++){
            possibleNeighbors[j] = neighbor++;
        }
    }

    public void move(int i, String symbol) throws IllegalMove {
        if(!isAvailable(i)) throw new IllegalMove("Space Taken");
        board[i] = symbol;
        spaces_available--;
    }

    public boolean isAvailable(int i) {
        return board[i].equals(" ");
    }

    public boolean isDraw() {
        return spaces_available <= 0;
    }

    public boolean isWin() {
        return checkHorizontal() || checkVeritcal() || checkDiagonal();
    }

    private boolean checkDiagonal() {
        return checkBackSlash() || checkForwardSlash();
    }

    private boolean checkForwardSlash() {
        int numberOfConsecutiveSymbols = 0;
        String previousSymbol = board[2];

        for (int i = 2; i < BOARD_SIZE - 1; i += 2) {
            if (previousSymbol.equals(board[i])) {
                numberOfConsecutiveSymbols++;
            } else {
                numberOfConsecutiveSymbols = 0;
            }
            if (previousSymbol.equals(" ")) {
                numberOfConsecutiveSymbols = 0;
            }
            if (numberOfConsecutiveSymbols == 3) {
                return true;
            }
            previousSymbol = board[i];
        }
        return false;
    }

    private boolean checkBackSlash() {
        int numberOfConsecutiveSymbols = 1;
        String previousSymbol = board[0];

        for (int i = 4; i < BOARD_SIZE; i += 4) {
            if (previousSymbol.equals(board[i])) {
                numberOfConsecutiveSymbols++;
            } else {
                numberOfConsecutiveSymbols = 1;
            }
            if (previousSymbol.equals(" ")) {
                numberOfConsecutiveSymbols = 1;
            }
            if (numberOfConsecutiveSymbols == 3) {
                return true;
            }
            previousSymbol = board[i];
        }
        return false;
    }

    private boolean checkHorizontal() {
        int numberOfConsecutiveSymbols = 1;
        String previousSymbol = board[0];
        for (int i = 1; i < BOARD_SIZE; i++) {
            if(previousSymbol.equals(board[i])){
                numberOfConsecutiveSymbols++;
            } else {
                numberOfConsecutiveSymbols = 1;
            }
            if (i % 3 == 0 || previousSymbol.equals(" ")) {
                numberOfConsecutiveSymbols = 1;
            }
            if (numberOfConsecutiveSymbols == 3){
                return true;
            }
            previousSymbol = board[i];

        }
        return false;
    }

    private boolean checkVeritcal() {
        int numberOfConsecutiveSymbols;
        String previousSymbol;
        int columnStart;

        for (int i = 0; i < 3; i++) {
            columnStart = i;
            numberOfConsecutiveSymbols = 0;
            previousSymbol = board[columnStart];
            for (int j = columnStart; j < BOARD_SIZE; j += 3) {
                if (previousSymbol.equals(board[j])) {
                    numberOfConsecutiveSymbols++;
                } else {
                    numberOfConsecutiveSymbols = 0;
                }
                if (previousSymbol.equals(" ")) {
                    numberOfConsecutiveSymbols = 0;
                }
                if (numberOfConsecutiveSymbols == 3) {
                    return true;
                }
                previousSymbol = board[j];
            }

        }
        return false;
    }


}
