package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.max;

public class Main9252 {

    static int[][] s;
    static char[] a;
    static char[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();

        int i,j = 0;
        for (i = 0; i < a.length; ++i)
            for (j = 0; j < b.length; ++j) {
                if (a[i] == b[j]) {
                    s[i + 1][j + 1] = s[i][j] + 1;
                } else {
                    s[i + 1][j + 1] = max(s[i][j + 1], s[i + 1][j]);
                }
            }
        System.out.println(s[i][j]);
        print(i, j);
    }

    static void print(int i, int j) {
        if (s[i][j] == 0) return;

        if (a[i - 1] == b[j - 1]) {
            print(i - 1, j - 1);
            System.out.println(a[i - 1]);
        } else {
            if (s[i - 1][j] > s[i][j - 1]) {
                print(i - 1, j);
            } else {
                print(i, j - 1);
            }
        }
    }
}
