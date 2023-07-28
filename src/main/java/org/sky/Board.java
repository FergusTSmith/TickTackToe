package org.sky;

public class Board {
    private String[][] board;

    public Board(){
        board = new String[3][3];
        for(int i = 0; i < 3; i++){
            for(int j=0; j < 3; j++){
                board[i][j] = "| - |";
            }
        }
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }
    public int setSquare(int x, int y, char c){
        //System.out.println(board[x][y]);
        //System.out.println(board[x][y].equals("| - |"));
        if(board[x][y].equals("| - |")){
            board[x][y] = "| " + c + " |";
            return 1;
        }else{
            return -1;
        }
    }
    public char isGameOver(){
        if(checkIfWon('x')){
            return 'x';
        }else if(checkIfWon('o')){
            return 'o';
        }else{
            return '-';
        }
    }
    public boolean checkIfWon(char c){
        String comparison = "| " + c + " |";
        // Check rows
        for(int i = 0; i < 3; i++){
            if(board[i][0].equals(comparison)){
                boolean won = true;
                for(int j = 0; j < 3; j++){
                    if(!board[i][j].equals(comparison)){
                        won = false;
                        break;
                    }
                }
                if(won){
                    return true;
                }
            }
        }

        //Check columns
        for(int i = 0; i < 3; i++){
            if(board[0][i].equals(comparison)){
                boolean won = true;
                for(int j = 0; j < 3; j++){
                    if(!board[j][i].equals(comparison)){
                        won = false;
                        break;
                    }
                }
                if(won){
                    return true;
                }
            }
        }
        if(board[0][0].equals(comparison) && board[1][1].equals(comparison) && board[2][2].equals(comparison)){
            return true;
        }else if(board[2][0].equals(comparison) && board[1][1].equals(comparison) && board[0][2].equals(comparison)){
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        String output = "";
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                output += board[i][j];
            }
            output += "\n";
        }
        return output;
    }
}
