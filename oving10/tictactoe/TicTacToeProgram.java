package oving10.tictactoe;

public class TicTacToeProgram implements GridGame {
    
    public static void main(String[] args) throws Exception {
        GridGameGUI.main(new String[] { TicTacToeProgram.class.getName() });
    }
    
    private T tictactoe;

    @Override
    public void init(String level) {
        System.out.println(level);
        if (level.length() >= 7 && level.contains("/") && level.contains(".")) {
            readGame(level);
        } else {
            // test if input is valid:
            if (level.length() == 2
                    && (!Character.isDigit(level.charAt(0)) || !Character
                            .isDigit(level.charAt(1)))) {
                // error report
                output.error("invalid input!");
            } else if (level.length() == 2
                    && (Character.isDigit(level.charAt(0)) || Character
                            .isDigit(level.charAt(1)))) {
                System.out.println("level til tall: "
                        + Integer.parseInt(level.charAt(0) + "") + " "
                        + Integer.parseInt(level.charAt(1) + ""));
                tictactoe = new T(Integer.parseInt(level.charAt(0) + ""),
                        Integer.parseInt(level.charAt(1) + ""));
                System.out.println("tictactoe har laget N*N");
            } else {
                tictactoe = new T();
                System.out.println("tictactoe har laget 3*3");
            }
        }
    }
    
    private GameOutput output;

    @Override
    public void run(GameOutput output) {
        // System.out.println(tictactoe.turen() + " 's turn");
        this.output = output;
        output.info(tictactoe.turen() + "'s turn");
    }
    
    public void readGame(String read) {
        String fileName;
        if (read.contains("<")) {
            fileName = read.substring(2);
            output.info("Game " + fileName + " loaded!");
        } else {
            fileName = read;
        }
        ReadAFile r = new ReadAFile();
        r.run(fileName);
        init(r.getM() + "" + r.getNxN());
        tictactoe.setNy(r.getTabel(), r.getM(), r.getNxN(), r.getSumere());
        System.out.println(tictactoe.toString());
    }
    
    public void writeGame(String write) {
        String fileName = write.substring(2);
        WriteAFile w = new WriteAFile();
        w.settInn(tictactoe.getTabel(), tictactoe.getM(), tictactoe.getNxN(),
                tictactoe.getSumere(), fileName);
        w.run();
        output.info("Game saved as: " + fileName);
    }

    @Override
    public Integer doCommand(String command) {
        // read a file <
        if (command.startsWith("<")) {
            readGame(command);
            // return 0;
        }
        // write a file >
        else if (command.startsWith(">")) {
            writeGame(command);
        } else {
            if (!tictactoe.isValid(command)) {
                output.info("not valid input!");
            } else {
                output.info(tictactoe.turen() + "'s turn");
                System.out.println(tictactoe.turen() + "'s turn");
                System.out.println(Integer.parseInt(command.charAt(0) + "")
                        + " settInn "
                        + Integer.parseInt(command.charAt(1) + ""));
                tictactoe.setInn(Integer.parseInt(command.charAt(0) + ""),
                        Integer.parseInt(command.charAt(1) + ""));
                // output.info(tictactoe.turen() + "'s turn");
                if (tictactoe.vinne() == 'O') {
                    output.info("Player O vin");
                    return 1;
                }
                if (tictactoe.vinne() == 'X') {
                    output.info("Player X win");
                    return -1;
                }
                if (tictactoe.getSumere() + 1 >= Math
                        .pow(tictactoe.getNxN(), 2)) {
                    output.info("no winers, game over");
                    return 0;
                }
            }
        }
        return null;
    }
    
    @Override
    public GridProvider getGridProvider() {
        return tictactoe;
    }
    
    @Override
    public String getTextFor(Object object) {
        // System.out.println(object.toString());
        return object.toString();
        // return null;
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
