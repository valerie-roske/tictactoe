package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by varoske on 3/6/14.
 */

public class TicTacToeGame {

    private Board board;
    private Player player;

    private boolean isPlayerOneTurn= true;


    public TicTacToeGame(Board board, Player player) {
        this.board= board;
        this.player = player;
    }


    public void play() throws IOException {

        BufferedReader bufferedReader=  new BufferedReader(new InputStreamReader(System.in));

        board.draw();

        while (!board.isFull()) {

            int location= player.makeMove(isPlayerOneTurn, bufferedReader);

            while (board.isLocationTaken(location)) {
                System.out.println("Location already taken, try again");
                location= player.makeMove(isPlayerOneTurn, bufferedReader);
            }

            board.mark(location, player.getPlayerMarker(isPlayerOneTurn));
            board.draw();
            isPlayerOneTurn= !isPlayerOneTurn;
        }

        System.out.println("Game is a draw");


    }



}
