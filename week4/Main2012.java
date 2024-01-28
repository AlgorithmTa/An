package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long sum = 0;

        int[] score = new int[N];
        for(int i = 0; i < N; i++){
            score[i] = Integer.parseInt(br.readLine());
            sum += score[i];
        }

        Arrays.sort(score);

        long maxSum = score[N-1] * (score[N-1] + 1) / 2;

        System.out.println(maxSum-sum);

    }
}
