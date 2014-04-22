package exam2008sjakk;

import java.util.Scanner;

public class ChessProgram implements Observer {
    
    private Board game;
    // ░ ⓐ ⓑ ⓒ ⓓ ⓔ ⓕ ⓖ ⓗ ░
    // 8 ♜ ♞ ♝ ♛ ♚ ♝ ♞ ♜ 8
    // 7 ♟ ♟ ♟ ♟ ♟ ♟ ♟ ♟ 7
    // 6 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 6
    // 5 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 5
    // 4 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 4
    // 3 ▓ ▓ ▓ ▓ ▓ ▓ ▓ ▓ 3
    // 2 ♙ ♙ ♙ ♙ ♙ ♙ ♙ ♙ 2
    // 1 ♖ ♘ ♗ ♕ ♔ ♗ ♘ ♖ 1
    // ░ ⓐ ⓑ ⓒ ⓓ ⓔ ⓕ ⓖ ⓗ ░
    public void init() {
        game = new Board();
        game.addObserver(this);
    }
    
    public void run() {
        Scanner sc = new Scanner(System.in);
        int moveSum=0;
        System.out.println("Write in <from-to>: a2-a3");
        while (true) {
            System.out.println(game.toString());
            String mt;
            while(true){
                System.out.println(turn(moveSum) + "'s turn: ");
                mt = sc.next();
                if(mt.length()==5){
                    String from=mt.substring(0,2);
                    if(game.getPiece(from).getPieceColor().getColor()==turn(moveSum)){
                        String to=mt.substring(3);
                        if(game.isValidPosition(mt.substring(0, 2)) & game.isValidPosition(to)){
                            if(game.isLegalMove(game.getPiece(from).getPieceColor(), from, to)){
                                game.movePiece(from, to);
                                moveSum++;
                                if (game.isCheck(game.getPiece(to).getPieceColor())) {
                                    System.out.println("The "+game.getPiece(to).getPieceColor().getColor()+"King is in Check!");
                                }
                                break;
                            }
                        }
                    }
                }
                System.out.println("Illegal move!");
            }
            if (game.checkmate()) {
                System.out.println(turn(moveSum) + " Win !");
                System.out.println("GAME OVER!");
                break;
            }
        }
        sc.close();
    }
    
    public static String turn(int moveSum) {
        if (moveSum % 2 == 0) {
            return "WHITE";
        } else {
            return "BLACK";
        }
    }
    
    @Override
    public void boardChanged(Board board, String pos, Piece piece) {
        System.out.println(pos + " changed");
        System.out.println(board.toString());
    }
}
