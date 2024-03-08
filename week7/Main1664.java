package week7;

/*
에라토스테네스의 체는 "소수가 되는 수의 배수를 지우면 남은 건 소수가 된다"
소수가 무엇인지 찾을 필요가 없으며 2부터 자기 자신을 제외한 배수가 되는 것을 지우면 됩니다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main1664 {

    static boolean prime[];
    static ArrayList<Integer> prime_numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1. 소수 구하기 --> 이부분은 함수로 따로 빼는 게 좋을듯
        prime(N);

        // 2. 연속합으로 주어진 정수 구할 수 있는지 판별  --> 이부분 또함 슬라이딩 윈도우 말고 투포인터도 가능
        /*
            연속합으로 주어진 정수를 구할 수 있는지 판별하는 방법은 슬라이딩 윈도우 알고리즘으로 확인하면 된다.
            에라토스테네스의 체를 이용해 구한 소수를 가지고 연속합을 만들면서 합이 크면 시작 Index를 늘리고 합이 작으면 끝 Index를 늘리는 방식으로 구한다.
         */

        int start=0, end=0, sum=0, count=0;

        while(true) {
            if(sum >= N ) sum -= prime_numbers.get(start++);
            else if(end == prime_numbers.size()) break;
            else sum += prime_numbers.get(end++);
            if(N==sum) count++;
        }
        System.out.println(count);
    }

    static void prime(int N){

        prime = new boolean[N+1];
        prime[0] = prime[1] = true;

        for(int i=2; i*i<=N; i++){
            if(!prime[i]) for(int j=i*i; j<=N; j+=i) prime[j]=true;
        }

        for(int i=1; i<=N;i++){
            if(!prime[i]) prime_numbers.add(i);
        }
    }
}
