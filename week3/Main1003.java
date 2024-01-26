package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1003 {

    static int countZero;
    static int countOne;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            countZero = 0;
            countOne = 0;
            checkFibo(Integer.parseInt(br.readLine()));

            System.out.println(countZero + " " + countOne);
        }

    }

    public static int checkFibo(int n){
        if (n == 0) {
            countZero++;
            return 0;
        }
        else if (n == 1) {
            countOne++;
            return 1;
        }
        else {
            return checkFibo(n-1) + checkFibo(n-2);
        }
    }

}
