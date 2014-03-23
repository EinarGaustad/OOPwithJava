package oving9.highscoreProgram;


public class Test {
    
    public static void main(String[] args) {
        HighscoreList list = new HighscoreList(3);
        System.out.println(list.size());
        list.addResult(5);
        System.out.println(list.size());
        list.addResult(6);
        System.out.println(list.size());
        // int[] list = new int[10];
        // for (int i = 0; i < list.length; i++) {
        // list[i] = (Integer) null;
        // }
        // list[0] = 2;
        // list[2] = 3;
        // for (int x : list) {
        // System.out.println(x);
        // }
    }
}
