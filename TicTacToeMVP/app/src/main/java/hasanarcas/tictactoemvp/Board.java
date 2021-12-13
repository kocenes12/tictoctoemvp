package hasanarcas.tictactoemvp;

public class Board {
    private static byte PLAYER_1_SYMBOL = 1;
    private static byte PLAYER_2_SYMBOL = 2;
    private boolean player1Turn = true;
    byte [][] board = new byte [3][3];
    BoardListener listener;
    public Board(BoardListener listener) {
        this.listener = listener;
    }
    public void move(byte row, byte col) {
        if(board[row][col] != 0){
            listener.invalidPlay(row, col);
        }
        if (player1Turn){
            board[row][col] = PLAYER_1_SYMBOL;
            listener.playedAt(BoardListener.PLAYER_1,row,col);
        }else{
            board[row][col] = PLAYER_2_SYMBOL;
            listener.playedAt(BoardListener.PLAYER_2,row,col);
        }
        player1Turn = !player1Turn;
    }
}
