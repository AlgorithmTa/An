package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main3109 {

    static char[][] pipe;
    static int R;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int count = 0;

        pipe = new char[R][C];

        for (int i = 0; i < R; i++) {
            pipe[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            if (checkPipe(i, 0)) count++;
        }

        System.out.println(count);
    }

    static boolean checkPipe(int x, int y) {

        pipe[x][y] = '-';

        //도착
        if(y == C-1) return true;
        //우측 위
        if(x > 0 && pipe[x-1][y+1] == '.')
            if(checkPipe(x-1, y+1)) return true;
        //우측
        if(pipe[x][y+1] == '.')
            if(checkPipe(x, y+1)) return true;
        //우측 하단
        if(x+1 < R && pipe[x+1][y+1] == '.')
            if(checkPipe(x+1, y+1)) return true;

        return false;

    }}
