package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class TicTacBufferedReader extends BufferedReader{
    public TicTacBufferedReader(Reader in, int sz) {
        super(in, sz);
    }

    public TicTacBufferedReader(Reader in) {
        super(in);
    }

    @Override
    public String readLine() throws RuntimeException {
        try {
            return super.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
