package org.sky;

import java.util.Random;
import java.util.Scanner;

public class TickTackToeGame {
    private Board board;

    public TickTackToeGame(){
        board = new Board();
    }

    public void makeMove(int x, int y, char c){
        int result = board.setSquare(x, y, c);
        System.out.println(result);
        while(result < 0){
            System.out.println("Error. There's already a move made on this square");
            Scanner s = new Scanner(System.in);
            x = s.nextInt();
            y = s.nextInt();
            result = board.setSquare(x, y, c);
        }
    }

    public void playTwoPlayerGame(){
        boolean gameWon = false;
        Scanner s = new Scanner(System.in);
        while(!gameWon){
            System.out.println(board);
            System.out.println("Player 1, please enter your x and y coordinates");
            int player1x = s.nextInt();
            int player1y = s.nextInt();
            makeMove(player1x, player1y, 'x');
            System.out.println(board);
            char winner = board.isGameOver();
            System.out.println(winner);
            if(winner == 'x'){
                gameWon = true;
                System.out.println("Game Over! X won");
                break;
            }else if(winner == 'o'){
                gameWon = true;
                System.out.println("Game Over! O won");
                break;
            }

            System.out.println("Player 2, please enter your x and y coordinates");
            int player2x = s.nextInt();
            int player2y = s.nextInt();
            makeMove(player2x, player2y, 'o');
            System.out.println(board);
            winner = board.isGameOver();
            System.out.println(winner);
            if(winner == 'x'){
                gameWon = true;
                System.out.println("Game Over! X won");
            }else if(winner == 'o'){
                gameWon = true;
                System.out.println("Game Over! O won");
            }
        }


    }
    public void playVersusAI(){
        boolean gameWon = false;
        Scanner s = new Scanner(System.in);
        while(!gameWon){
            System.out.println(board);
            System.out.println("Player 1, please enter your x and y coordinates");
            int player1x = s.nextInt();
            int player1y = s.nextInt();
            makeMove(player1x, player1y, 'x');
            System.out.println(board);
            char winner = board.isGameOver();
            System.out.println(winner);
            if(winner == 'x'){
                gameWon = true;
                System.out.println("Game Over! X won");
                break;
            }else if(winner == 'o'){
                gameWon = true;
                System.out.println("Game Over! O won");
                break;
            }
            makeAIMove();
        }
    }
    public void makeAIMove(){
        Random r = new Random();
        makeMove(r.nextInt(3), r.nextInt(3), 'o');
    }
}
