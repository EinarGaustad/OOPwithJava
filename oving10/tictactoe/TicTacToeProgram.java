package oving10.tictactoe;

public class TicTacToeProgram implements GridGame {
    
    public static void main(String[] args) throws Exception {
        GridGameGUI.main(new String[] { TicTacToeProgram.class.getName() });
    }
    
    private Undo       tictactoe;
    private GameOutput output;
    private boolean    runInit;
    private String     intro = "'< name' for load a game" + "\n"
                                     + "'> name' for save game" + "\n"
                                     + "u for undo" + "\n" + "r for redo";
    private String     error;

    @Override
    public void init(String level) {
        if (level.length() >= 7 && level.contains("/") && level.contains(".")) {
            runInit = true;
            readGame(level);
        } else {
            // test if input is valid:
            if (level.length() == 2
                    && (!Character.isDigit(level.charAt(0)) || !Character
                            .isDigit(level.charAt(1)))) {
                // error report
                error = "invalid input! Write two digital number 'MN' example: 33";
            } else if (level.length() == 2
                    && (Character.isDigit(level.charAt(0)) || Character
                            .isDigit(level.charAt(1)))) {
                System.out.println("level til tall: "
                        + Integer.parseInt(level.charAt(0) + "") + " "
                        + Integer.parseInt(level.charAt(1) + ""));
                if (Integer.parseInt(level.charAt(0) + "") > Integer
                        .parseInt(level.charAt(1) + "")) {
                    error = "'MN', M is winning number, N is playground size N*N, 'M (must) <= N'";
                }
                tictactoe = new Undo(Integer.parseInt(level.charAt(0) + ""),
                        Integer.parseInt(level.charAt(1) + ""));
            } else {
                tictactoe = new Undo();
                System.out.println("tictactoe har laget 3*3");
                System.out.println(": " + tictactoe);
            }
        }
    }
    
    @Override
    public void run(GameOutput output) {
        this.output = output;
        if (error != null) {
            output.error(error);
        } else {
            output.info(intro);
        }
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
        if (runInit) {
            init(r.getM() + "" + r.getNxN());
        }
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
        if (error != null) {
            output.info(error);
            return 0;
        }
        // read a file <
        if (command.startsWith("<")) {
            runInit = false;
            readGame(command);
        }
        // write a file >
        else if (command.startsWith(">")) {
            writeGame(command);
        } else if (command.startsWith("u")) {
            String message = tictactoe.undo();
            if (message != null) {
                output.info(message);
            } else {
                output.info("undo is executed");
            }
        } else if (command.startsWith("r")) {
            String message = tictactoe.redo();
            if (message != null) {
                output.info(message);
            } else {
                output.info("redo is executed");
            }
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
                System.out.println(tictactoe.toString());
                if (tictactoe.vinne() == 'O') {
                    output.info("Player O vin");
                    return 1;
                }
                if (tictactoe.vinne() == 'X') {
                    output.info("Player X win");
                    return -1;
                }
                if (tictactoe.getSumere() >= Math.pow(tictactoe.getNxN(), 2)) {
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
