package tasks.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[3][3];

        for (int i = 0; i < 3; i++) {
            arr[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        flipArray(arr);
        printArray(arr);
    }

    public static void flipArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                swap(i, j, arr);
            }
        }
    }

    public static void swap(int i, int j, int[][] arr) {
        int temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }

    public static void printArray(int[][] array) {
        for (int[] chars : array) {
            for (int c : chars) {
                System.out.print(c + " ");
            }

            System.out.println();
        }
    }
}
