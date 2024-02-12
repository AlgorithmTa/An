package week5_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11404 {

    static int[][] graph;
    static int n;
    static final int max = 999999999;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new int[n+2][n+2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i==j) continue;
                graph[i][j] = max;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            //같은 노선에 여러 가지가 올 수 있음 아래 부분에서 틀린것 같음
            //graph[a][b] = value;
            graph[a][b] = Math.min(value, graph[a][b]);
        }


        floyd();
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) { //중간 노드
            for (int i = 1; i <= n; i++) { //시작
                for (int j = 1; j <= n; j++) { //도착
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for(int i = 1; i <=n; i++){
            for(int j = 1; j <=n; j++){
                if(graph[i][j] == max) System.out.print(0 + " ");
                else System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
