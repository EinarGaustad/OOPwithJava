package test.recursion;

public class LuckyNumber {
    
    public static boolean isLuckyNumber(int number) {
        int lastDigit = number % 10;
        if (lastDigit == 8) {
            return true;
        } else if (number < 10 && number != 8) {
            return false;
        } else {
            return isLuckyNumber(number / 10);
        }
    }
    
    public static int pow2(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 2;
        } else {
            int sum = pow2(n - 1);
            return sum * 2;
        }
    }
    
    public static int mystery(int n) {
        if (n <= 0) {
            return 0;
        } else {
            int smaller = n - 1;
            return mystery(smaller) + n * n;
        }
    }

    public static void main(String[] args) {
        System.out.println(LuckyNumber.isLuckyNumber(819911));
        System.out.println(LuckyNumber.pow2(10));
        System.out.println(LuckyNumber.mystery(4));
    }
}
