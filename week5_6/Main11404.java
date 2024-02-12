package week5_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11404 {

    static int[][] graph;
    static int n;
    final static int max = 100001;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new int[m + 1][m + 1];

        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                graph[i][j] = max;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph[a][b] = value;
        }

        floyd();
        print();
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) { //중간 노드
            for (int i = 1; i <= n; i++) { //시작
                for (int j = 1; j <= n; j++) { //도착
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

    private static void print(){
        for(int i = 1; i <=n; i++){
            for(int j = 1; j <=n; j++){
                if(graph[i][j] == max || i == j) System.out.print(0 + " ");
                else System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
