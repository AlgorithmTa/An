package week5_6.again;

import java.io.*;
import java.util.*;

public class Main20304 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[N+1];
        Queue<Integer> queue = new ArrayDeque<Integer>();
        int depth = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            queue.offer(temp);
            visited[temp] = true;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            while(size-- > 0) {
                int temp = queue.poll();
                // queue에서 빼준 값과 한 자리만 차이나는 값 찾기
                int x = 1;
                while (x <= N) {
                    if ((x^temp) <= N && !visited[x^temp]) {
                        visited[x^temp] = true;
                        queue.offer(x^temp);
                    }
                    x =  x<<1;
                }
            }
        }
        System.out.println(depth-1); // 1 빼야함
    }

}