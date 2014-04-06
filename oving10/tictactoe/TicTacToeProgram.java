package oving10.tictactoe;

import java.util.Scanner;

public class TicTacToeProgram implements GridGame {
    
    public static void main(String[] args) throws Exception {
        GridGameGUI.main(new String[] { TicTacToeProgram.class.getName() });

        TicTacToe tictactoe = new TicTacToe();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println(tictactoe.toString());
            if (tictactoe.vinne() == ' ') {
                int x = 0;
                int y = 0;
                String flytte;
                while (true) {
                    flytte = in.next();
                    if (tictactoe.isValid(flytte))
                        break;
                    else
                        System.out
                                .println("feil inndato, kjekk skrive inn igjen!");
                }
                x = Integer.parseInt("" + flytte.charAt(0));
                y = Integer.parseInt("" + flytte.charAt(1));
                tictactoe.setInn(x, y);
                
            } else
                break;
            
            if (tictactoe.getSumere() == 9) {
                System.out.println(tictactoe.toString());
                break;
            }
        }
        in.close();
    }
    
    @Override
    public void init(String streng) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void run(GameOutput game) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public Integer doCommand(String command) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public GridProvider getGridProvider() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String getTextFor(Object object) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String getImageFor(Object object) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Integer gridElementInput(int x, int y) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Integer directionInput(int dx, int dy) {
        // TODO Auto-generated method stub
        return null;
    }
}
