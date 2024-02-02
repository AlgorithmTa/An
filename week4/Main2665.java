package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2665 {

    static int n;
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int map[][];
    static int visited[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            Arrays.fill(visited[i], Integer.MAX_VALUE);

            for(int j = 0; j < n; j++) {
                if(line.charAt(j) == '1') map[i][j] = 1;
                else map[i][j] = 0;
            }
        }

        //자꾸 2가 나와야하는데 14가 나온다... 코드 다시 봐야함....
        bfs(0,0);

        System.out.println(visited[n-1][n-1]);
    }

    //bfs 문제 흔하게 dx, dy 사용하는 유형
    private static void bfs(int x, int y){

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = 0;

        //엠티 아니라면
        // 코드 다시 보기
        while (!q.isEmpty()){
            int[] step = q.poll();
            int x1 = step[0];
            int y1 = step[1];

            for(int i = 0; i < 4; i++){
                int nowX = x1 + dx[i];
                int nowY = y1 + dy[i];

                if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < n) {
                    if (visited[nowX][nowY] > visited[x1][y1]) {
                        if (map[nowX][nowY] == '1') {
                            q.add(new int[]{nowX, nowY});
                            visited[nowX][nowY] = visited[x1][y1];
                        } else {
                            q.add(new int[]{nowX, nowY});
                            visited[nowX][nowY] = visited[x1][y1] + 1;
                        }
                    }
                }
            }

        }

    }
}
