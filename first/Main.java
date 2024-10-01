package tasks.first;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(max(5, 3));
        System.out.println(div(5, 4));
        System.out.println(parseInt("5"));
        System.out.println(checkAge(18));
        System.out.println(sqrt(36));
        System.out.println(factorial(5));
        System.out.println(checkArray(new int[] {5,3,4,2,1}));
        System.out.println(pow(2, 6));
        System.out.println(subStr("abcdef", 2));
        System.out.println(find(new int[] {1,2,3,4,5}, 5));
        System.out.println(toBinary(16));
        System.out.println(mod(5, 2));
        System.out.println(get(List.of(5,4,3,2), 2));
        System.out.println(checkPassword("abcdefasd"));
        System.out.println(checkDate("25.09.2004"));
        System.out.println(concat("a", "b"));
        System.out.println(getMod(5, 2));
        System.out.println(sqrt(16D));
        System.out.println(toFarengate(25));
        System.out.println(isEmpty("not-empty"));
    }

    public static int max(int a, int b) {
        if (a == b) {
            throw new IllegalArgumentException();
        }

        return Integer.max(a, b);
    }

    public static int div(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Делитель не может быть равен нулю!");
        }

        return a / b;
    }

    public static int parseInt(String str) {
        return Integer.parseInt(str);
    }

    public static int checkAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException();
        }

        return age;
    }

    public static double sqrt(int a) {
        if (a < 0) {
            throw new IllegalArgumentException();
        }

        return Math.sqrt(a);
    }

    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        if (n <= 1) {
            return 1;
        }

       return n * factorial(n - 1);
    }

    public static boolean checkArray(int[] array) {
        for (int i : array) {
            if (i == 0) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    public static int pow(int a, int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return a;
        }

        return a * pow(a, n - 1);
    }

    public static String subStr(String string, int a) {
        if (a > string.length()) {
            throw new IllegalArgumentException();
        }

        return string.substring(a);
    }

    public static boolean find(int[] array, int a) {
        for (int i : array) {
            if (i == a) {
                return true;
            }
        }

        throw new IllegalArgumentException();
    }

    public static String toBinary(int x) {
        return Integer.toBinaryString(x);
    }

    public static boolean mod(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException();
        }

        return a % b == 0;
    }

    public static int get(List<Integer> list, int idx) {
        if (idx < 0 || idx >= list.size()) {
            throw new IllegalArgumentException();
        }

        return list.get(idx);
    }

    public static boolean checkPassword(String pwd) {
        class WeakPasswordException extends RuntimeException { }

        if (pwd.length() < 8) {
            throw new WeakPasswordException();
        }

        return true;
    }

    public static boolean checkDate(String date) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return true;
    }

    public static String concat(String a, String b) {
        if (a == null || b == null) {
            throw new NullPointerException();
        }

        return a + b;
    }

    public static int getMod(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException();
        }

        return a % b;
    }

    public static double sqrt(double a) {
        if (a < 0) {
            throw new IllegalArgumentException();
        }

        return Math.sqrt(a);
    }

    public static double toFarengate(double c) {
        if (c <= -273.15) {
            throw new IllegalArgumentException();
        }

        return (c * 9/5) + 32;
    }

    public static String isEmpty(String s) {
        if (s.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return s;
    }
}
