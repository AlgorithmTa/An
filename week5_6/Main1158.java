package week5_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        int item = 0;

        for(int i = K; i < N+K; i++){ //반복문 7번
            if(i > N ){
                queue.add(i%N);
            } else {
                queue.add(i); // 3 4 5 6 7
            }
        }

        System.out.print("<");
        System.out.print(queue.poll() + ", "); //3이 나옴

        while(!queue.isEmpty()){
            //3번 반복
            for(int i = 0; i <K-1; i++){
                item = queue.poll();
                queue.add(item);
            }
            item = queue.poll();

            if(queue.isEmpty()){
                System.out.print(item + ">");
            } else {
                System.out.print(item + ", ");
            }
        }
    }
}
