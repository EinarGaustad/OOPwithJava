package oving10.tictactoe;

public class TicTacToeProgram implements GridGame {
    
    
    public static void main(String[] args) throws Exception {
        GridGameGUI.main(new String[] { TicTacToeProgram.class.getName() });
    }

    private T      tictactoe;
    private String error;
    private String warning;

    // @Override
    public void init(String streng) {
        if (streng == "") {
            tictactoe = new T();
        }
        // test if input is valid:
        else if (streng.length() != 2 || !Character.isDigit(streng.charAt(0))
                || !Character.isDigit(streng.charAt(1))) {
            // error report
            error = "invalid input!";
        } else {
            tictactoe = new T(Integer.parseInt(streng.charAt(0) + ""),
                    Integer.parseInt(streng.charAt(1) + ""));
        }
    }
    
    @Override
    public void run(GameOutput game) {
        game.info(tictactoe.turen() + "");
        game.error(error);
        game.warning(warning);
    }
    
    @Override
    public Integer doCommand(String command) {
        if (!tictactoe.isValid(command)) {
            warning = "not valid input!";
        } else if (tictactoe.vinne() == 'O') {
            return 1;
        } else if (tictactoe.vinne() == 'X') {
            return -1;
        } else {
            tictactoe.setInn(Integer.parseInt(command.charAt(0) + ""),
                    Integer.parseInt(command.charAt(1) + ""));
        }
        return 0;
    }
    
    @Override
    public GridProvider getGridProvider() {
        return tictactoe;
    }
    
    @Override
    public String getTextFor(Object object) {
        return object.toString();
    }
    
    @Override
    public String getImageFor(Object object) {
        return null;
    }
    
    @Override
    public Integer gridElementInput(int x, int y) {
        return doCommand(x + "" + y);
    }
    
    @Override
    public Integer directionInput(int dx, int dy) {
        return doCommand(dx + "" + dy);
    }
}
