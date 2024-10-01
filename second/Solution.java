package tasks.second;

import java.io.IOException;

public class Solution {
    public static char[][] chars = {
            {'a', 'b', 'c', 'd', 'e', 'f'},
            {'j', 'h', 'i', 'j', 'k', 'l'},
            {'m', 'n', 'o', 'p', 'q', 'r'},
            {'s', 't', 'u', 'v', 'w', 'x'}};

    public static void main(String[] args) throws IOException {
        changeArray(chars);
        printArray(chars);
    }

    public static void changeArray(char[][] array) {
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 1; j < array[0].length - 1; j++) {
                array[i][j] = '-';
            }
        }
    }

    public static void printArray(char[][] array) {
        for (char[] chars : array) {
            for (char c : chars) {
                System.out.print(c + " ");
            }

            System.out.println();
        }
    }
}
