package test;

public class Continue {
    
    public static void main(String[] args) {
        System.out.println("start:");
        for (int i = 0; i < 4; i++) {
            System.out.println("start nr:." + i);
            if (i == 2) {
                continue;
            }
            System.out.println("execute this line after continue..." + i);
        }
        System.out.println("start break:-------------");
        System.out.println("start:");
        for (int i = 0; i < 4; i++) {
            System.out.println("loop nr:." + i);
            if (i == 2) {
                break;
            }
            System.out.println("execute this line after continue..." + i);
        }
        int s = 0;
        int i = 0;
        while (true) {
            for (int j = 0; j < 3; j++) {
                if (j == 1) {
                    continue;
                }
                int b = 0;
                do {

                    s++;
                    System.out.println("do: s: " + s + " i: " + i + " j: " + j
                            + " b: " + b);
                    b++;
                } while (b < 3);
                System.out.println("for: s: " + s + " i: " + i + " j: " + j
                        + " b: " + b);
            }
            System.out.println("while: s: " + s + " i: " + i);
            i++;
            if (i == 3) {
                break;
            }
        }
        
    }
}
